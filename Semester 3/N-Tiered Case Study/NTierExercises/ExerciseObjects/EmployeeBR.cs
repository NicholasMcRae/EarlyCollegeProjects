using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Windows.Media;

namespace ExerciseObjects
{
    /// <summary>
    ///		EmployeeBR utilizes BrokenRules Class to maintain state
    /// </summary>
    public class EmployeeBR
    {
        private int _departmentid;
        private string _email;
        private BrokenRules _rules;

        /// <summary>
        /// Collection to look after colors
        /// </summary>
        public Dictionary<string,SolidColorBrush> PropertyColors; //keep track of colors - black ok, red rule broken

        /// <summary>
        /// event to raise based on event coming from Broken Rules class
        /// </summary>
        public event RuleBrokenEventHandler evntEmployeeStillBroken; // event

        /// <summary>
        /// DepartmentID property
        /// </summary>
        public int DepartmentID
        {
            get
            {
                return _departmentid;
            }
            set
            {
                try
                {
                    if (value > 99 && value < 701) // assume we have 7 departments
                    {
                        _departmentid = value;
                        _rules.MaintainRule("department", false); // remove from collection
                        PropertyColors["department"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("department", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["department"] = new SolidColorBrush(Colors.Red);
                }
            }
        }

        /// <summary>
        /// Email Property
        /// </summary>
        public string Email
        {
            get
            {
                return _email;
            }
            set
            {
                try
                {
                    Regex _regex = new Regex("\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

                    if (!_regex.Match(value).Success)
                        throw new System.Exception(); //this is caught below

                    _email = value;
                    _rules.MaintainRule("email", false);   // remove from collection
                    PropertyColors["email"] = new SolidColorBrush(Colors.Black);
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("email", true);    // add or replace in collection
                    String strDbg = ex.Message;
                    PropertyColors["email"] = new SolidColorBrush(Colors.Red);
                }
            }
        }

        /// <summary>
        /// Constructor, setup broken rules object and break all rules
        /// </summary>
        public EmployeeBR()
        {
            _rules = new BrokenRules();
            _rules.evntStillBroken += new RuleBrokenEventHandler(EmployeeRulesBroken); // register eventhandler for BR
            // break all the rules
            _rules.MaintainRule("department", true);
            _rules.MaintainRule("email", true);
            PropertyColors = new Dictionary<string,SolidColorBrush>();
            PropertyColors["department"] = new SolidColorBrush(Colors.Red);
            PropertyColors["email"] = new SolidColorBrush(Colors.Red);
        }

        /// <summary>
        /// event handler for BrokenRules.evntStillBroken 
        /// </summary>
        /// <param name="blnIsBroken">boolean will be passed from broken rules</param>
        public void EmployeeRulesBroken(bool blnIsBroken)
        {
            if (evntEmployeeStillBroken != null)
                evntEmployeeStillBroken(blnIsBroken);  // raise event for presentation layer
        }
    }
}

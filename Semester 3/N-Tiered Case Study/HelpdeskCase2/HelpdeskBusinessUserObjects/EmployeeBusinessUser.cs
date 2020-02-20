using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Diagnostics;
using System.Runtime.Serialization.Formatters.Binary;
using System.IO;
using System.Windows.Media;

//EmployeeDataReference.EmployeeDataServiceClient

namespace HelpdeskBusinessUserObjects
{
    public class EmployeeBusinessUser : ConfigBusinessUser
    {
        private int _departmentID;
        private string _email;
        private int _employeeID;
        private byte[] _entity;
        private string _firstName;
        private string _lastName;
        private string _phoneNo;
        private string _departmentName;
        private BrokenRules _rules;
        private string _title;
        //PropertyColors

        /// <summary>
        /// Collection to look after colors
        /// </summary>
        public Dictionary<string, SolidColorBrush> PropertyColors; //keep track of colors - black ok, red rule broken

        /// <summary>
        /// event to raise based on event coming from Broken Rules class
        /// </summary>
        public event RuleBrokenEventHandler evntEmployeeStillBroken; // event
        public event RuleBrokenEventHandler evntEmployeeIsValid;//second event

        /// <summary>
        /// DepartmentID property
        /// </summary>
        public int DepartmentID
        {
            get
            {
                return _departmentID;
            }
            set
            {
                try
                {
                    if (value < 1200 && (value % 100) == 0) // assume we have 7 departments
                    {
                        _departmentID = value;
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
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// Email property
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
                    Regex regexObject = new Regex("\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

                    if (regexObject.IsMatch(value)) // assume we have 7 departments
                    {
                        _email = value;
                        _rules.MaintainRule("email", false); // remove from collection
                        PropertyColors["email"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("email", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["email"] = new SolidColorBrush(Colors.Red);
                }//end catch
            }//end setter
        }//end method



        /// <summary>
        /// EmployeeID property
        /// </summary>
        public int EmployeeID
        {
            get
            {
                return _employeeID;
            }
            set
            {
                try
                {

                    _employeeID = value;


                }
                catch (Exception ex)
                {
                    string strDbg = ex.Message;
                    PropertyColors["employeeid"] = new SolidColorBrush(Colors.Red);
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// FirstName property
        /// </summary>
        public string FirstName
        {
            get
            {
                return _firstName;
            }
            set
            {
                try
                {
                    if (value.Length > 0 && value.Length < 26 && char.IsUpper(value[0])) // assume we have 7 departments
                    {
                        _firstName = value;
                        _rules.MaintainRule("firstname", false); // remove from collection
                        PropertyColors["firstname"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("firstname", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["firstname"] = new SolidColorBrush(Colors.Red);
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// LastName property
        /// </summary>
        public string LastName
        {
            get
            {
                return _lastName;
            }
            set
            {
                try
                {

                    if (value.Length > 0 && value.Length < 26 && char.IsUpper(value[0])) // assume we have 7 departments
                    {
                        _lastName = value;
                        _rules.MaintainRule("lastname", false); // remove from collection
                        PropertyColors["lastname"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("lastname", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["lastname"] = new SolidColorBrush(Colors.Red);
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// Email property
        /// </summary>
        public string PhoneNo
        {
            get
            {
                return _phoneNo;
            }
            set
            {
                try
                {
                    Regex regexObject = new Regex(@"^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$");

                    if (regexObject.IsMatch(value)) // assume we have 7 departments
                    {
                        _phoneNo = value;
                        _rules.MaintainRule("phoneno", false); // remove from collection
                        PropertyColors["phoneno"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("phoneno", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["phoneno"] = new SolidColorBrush(Colors.Red);
                }//end catch
            }//end setter
        }//end method

        public string Title
        {
            get
            {
                return _title;
            }
            set
            {
                try
                {
                    if (value == "Mr." || value == "Mrs." || value == "Ms." || value == "Dr.") // assume we have 7 departments
                    {
                        _title = value;
                        _rules.MaintainRule("title", false); // remove from collection
                        PropertyColors["title"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("title", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["title"] = new SolidColorBrush(Colors.Red);
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// event handler for BrokenRules.evntStillBroken 
        /// </summary>
        /// <param name="blnIsBroken">boolean will be passed from broken rules</param>
        public void EmployeeRulesBroken(bool blnIsBroken)
        {
            if (evntEmployeeStillBroken != null)
                evntEmployeeStillBroken(blnIsBroken);  // raise event for presentation layer
        }

        public EmployeeBusinessUser()
        {
            _rules = new BrokenRules();
            _rules.evntStillBroken += new RuleBrokenEventHandler(EmployeeRulesBroken);
            // break all the rules
            _rules.MaintainRule("department", true);
            _rules.MaintainRule("email", true);
            _rules.MaintainRule("phoneno", true);
            _rules.MaintainRule("lastname", true);
            _rules.MaintainRule("firstname", true);
            _rules.MaintainRule("title", true);

            PropertyColors = new Dictionary<string, SolidColorBrush>();
            PropertyColors["department"] = new SolidColorBrush(Colors.Red);
            PropertyColors["email"] = new SolidColorBrush(Colors.Red);
            PropertyColors["phoneno"] = new SolidColorBrush(Colors.Red);
            PropertyColors["lastname"] = new SolidColorBrush(Colors.Red);
            PropertyColors["firstname"] = new SolidColorBrush(Colors.Red);
            PropertyColors["title"] = new SolidColorBrush(Colors.Red);
        }//end constructor

        ///<summary>
        /// DepartmentName Property - string
        /// </summary>


        //GetByID -Will accept an integer as an input parameter from the presentation layer,
        //indicating which employee the user is interested in. Will instantiate a dictionary to receive 
        //the data from the data layer. Will instantiate an instance of EmployeeBusinessData. Will call 
        //the EmployeeBusinessData.GetByID method, passing the integer to it and receiving a loaded dictionary from it. Will load 
        //the instance members from the contents of the dictionary. Finally, will call ConfigBusinessUsers's ErrorRoutine if there is a problem.

        public void GetByID(int empid)
        {
            EmployeeDataReference.EmployeeDataServiceClient empData;

            try //employeeID must be set by client before running this method
            {
                empData = new EmployeeDataReference.EmployeeDataServiceClient();


                Dictionary<string, Object> DictionaryEmployee = (Dictionary<string, Object>)ConfigBusinessUser.Deserializer(empData.GetByID(empid));
                _employeeID = (int)DictionaryEmployee["emp"];
                _title = (string)DictionaryEmployee["title"];
                _firstName = (string)DictionaryEmployee["firstname"];
                _lastName = (string)DictionaryEmployee["lastname"];
                _phoneNo = (string)DictionaryEmployee["phoneno"];
                _email = (string)DictionaryEmployee["email"];
                _departmentID = (int)DictionaryEmployee["departmentid"];
                _entity = (byte[])DictionaryEmployee["entity"];

            }
            catch (Exception ex)
            {
                ConfigBusinessUser.ErrorRoutine(ex, "EmployeeBusinessUser", "GetByID");
            }

        }//end GetById

        //Create - Returns an integer, indicating the value of the primary key just added.
        //Will instantiate a new dictionary to be used to pass data to the EmployeeBusinessData 
        //object. Will instantiate a new EmployeeBusinessData instance. Will load all instance
        //members into the dictionary. Will call the EmployeeBusinessData.Create method with
        //the dictionary as a parameter and receive an integer indicating the number of rows added. 
        //Finally, will call ConfigBusinessUser's ErrorRoutine if there is a problem.
        //going to be creating a dictionary and loading it with member variables and then deserializing it and putting it into the data
        //object create and returning the employee id

        public int Create()
        {
            EmployeeDataReference.EmployeeDataServiceClient busData;
            int empID = -1;

            try
            {
                Dictionary<string, object> createDictionary = new Dictionary<string, object>();
                createDictionary["title"] = _title;
                createDictionary["firstname"] = _firstName;
                createDictionary["lastname"] = _lastName;
                createDictionary["phoneno"] = _phoneNo;
                createDictionary["email"] = _email;
                createDictionary["departmentid"] = _departmentID;

                busData = new EmployeeDataReference.EmployeeDataServiceClient();
                byte[] byteArray = ConfigBusinessUser.Serializer(createDictionary);
                empID = busData.Create(byteArray);

            }

            catch (Exception ex)
            {
                ConfigBusinessUser.ErrorRoutine(ex, "EmployeeBusinessUser", "Create");
            }

            return empID;
        }



        //Update - Returns an integer, indicating the number of rows updated (1 worked, anything else error). 
        //Will instantiate a new dictionary to be used to pass data to the EmployeeBusinessData object. 
        //Will instantiate a new EmployeeBusinessData instance. Will load all instance members into the dictionary. 
        //Will call the EmployeeBusinessData.Update method with the dictionary as a parameter and receive an integer
        //indicating the number of rows updated. Finally, will call ConfigBusinessUser's ErrorRoutine if there is a problem.

        public int Update()
        {
            int rowsUpdated = -1;
            EmployeeDataReference.EmployeeDataServiceClient busData;

            try
            {
                Dictionary<string, object> updateDictionary = new Dictionary<string, object>();
                updateDictionary["title"] = _title;
                updateDictionary["firstname"] = _firstName;
                updateDictionary["lastname"] = _lastName;
                updateDictionary["phoneno"] = _phoneNo;
                updateDictionary["email"] = _email;
                updateDictionary["departmentid"] = _departmentID;
                updateDictionary["entity"] = _entity;

                busData = new EmployeeDataReference.EmployeeDataServiceClient();
                byte[] updateArray = ConfigBusinessUser.Serializer(updateDictionary);
                rowsUpdated = busData.Update(updateArray);
            }
            catch (Exception ex)
            {
                ConfigBusinessUser.ErrorRoutine(ex, "EmployeeBusinessUser", "Update");
            }

            return rowsUpdated;

        }//end Update method


        //Delete - pass the current employee id to the EmployeeBusinessData object and indicate number of rows deleted (should be 1)

        public int Delete(int empID)
        {
            int rowsDeleted = -1;

            EmployeeDataReference.EmployeeDataServiceClient busData;

            try
            {
                busData = new EmployeeDataReference.EmployeeDataServiceClient();
                rowsDeleted = busData.Delete(empID);
            }

            catch (Exception ex)
            {
                ConfigBusinessUser.ErrorRoutine(ex, "EmployeeBusinessUser", "Delete");
            }


            return rowsDeleted;
        }

        //GetAll - Returns a generic List of EmployeeBusinessUser objects (will be eventually used to load listview in the presentation layer).
        //Will instantiate a new instance of the EmployeeBusinessData object.
        //Will instantiate a new instance of a List of Employee objects (received from EmployeeBusinessData.GetAll method). 
        //Will instantiate a new instance of a List collection typed with EmployeeBusinessUser. 
        //Will load the List from the contents of the received List from EmployeeBusinessData. 
        //Loop through the Employee List creating an EmployeeBusinessUser instance for each entry , then add the instance to the list. 
        //Finally, will call ConfigBusinessUser's ErrorRoutine if there is a problem.

        public List<EmployeeBusinessUser> GetAll()
        {
            EmployeeDataReference.EmployeeDataServiceClient busData;
            List<EmployeeBusinessUser> businessUserList = new List<EmployeeBusinessUser>();

            try
            {
                busData = new EmployeeDataReference.EmployeeDataServiceClient();
                EmployeeDataReference.SerializedEmployee[] empdata = busData.GetAll();

                foreach (EmployeeDataReference.SerializedEmployee emp in empdata)
                {
                    EmployeeBusinessUser empBus = new EmployeeBusinessUser();
                    empBus.loadDefaultValues();
                    empBus.DepartmentID = emp.DepartmentID;
                    //depBus.Department = depBus.Department.DepartmentName;
                    empBus.EmployeeID = emp.EmployeeID;
                    empBus.FirstName = emp.FirstName;
                    empBus.LastName = emp.LastName;
                    empBus.PhoneNo = emp.PhoneNo;
                    empBus.Email = emp.Email;
                   // empBus.DepartmentID = emp.DepartmentID;
                    businessUserList.Add(empBus);
                }

            }

            catch (Exception ex)
            {
                ConfigBusinessUser.ErrorRoutine(ex, "EmployeeBusinessUser", "GetAll");
            }

            return businessUserList;
        }





    }//end class
}

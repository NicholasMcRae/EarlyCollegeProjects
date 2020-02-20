using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Diagnostics;
using System.Runtime.Serialization.Formatters.Binary;
using System.IO;
using System.Windows.Media;

namespace HelpdeskBusinessUserObjects
{
    public class CallBusinessUser : ConfigBusinessUser
    {

        private int _callID;
        private DateTime _dateClosed;
        private DateTime _dateOpened;
        private int _employeeID;
        private byte[] _entity;
        private byte[] _notes;
        private bool _openStatus;
        private int _problemID;
        private BrokenRules _rules;
        private int _techID;

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
        /// CallID property
        /// </summary>
        public int CallID
        {
            get
            {
                return _callID;
            }
            set
            {
                try
                {                    
                        _callID = value;                      
                    
                }
                catch (Exception ex)
                {                    
                    string strDbg = ex.Message;                    
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// Date Closed property
        /// </summary>
        public DateTime DateClosed
        {
            get
            {
                return _dateClosed;
            }
            set
            {               
                
                try
                {
                    if (value == null)
                    {
                        value = System.DateTime.MinValue;
                    }

                     _dateClosed = value;
                        
                    
                }
                catch (Exception ex)
                {                   
                    string strDbg = ex.Message;
                 
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// DateOpened property
        /// </summary>
        public DateTime DateOpened
        {
            get
            {
                return _dateOpened;
            }
            set
            {
                try
                {
                    if (value == null)
                    {
                        value = System.DateTime.MinValue;
                    }

                    if (value >= System.DateTime.MinValue) // assume we have 7 departments
                    {
                        _dateOpened = value;
                        _rules.MaintainRule("dateopened", false); // remove from collection
                        PropertyColors["dateopened"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("dateopened", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["dateopened"] = new SolidColorBrush(Colors.Red);
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
                    if (value > 0) // assume we have 7 departments
                    {
                        _employeeID = value;
                        _rules.MaintainRule("employeeid", false); // remove from collection
                        PropertyColors["employeeid"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("employeeid", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["employeeid"] = new SolidColorBrush(Colors.Red);
                }//end catch
            }//end setter
        }//end method

       
        /// <summary>
        /// Notes property
        /// </summary>
        public byte[] Notes
        {
            get
            {
                return _notes;
            }
            set
            {
                try
                {
                    if (value.Length > 0) // assume we have 7 departments
                    {
                        _notes = value;
                        _rules.MaintainRule("notes", false); // remove from collection
                        PropertyColors["notes"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("notes", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["notes"] = new SolidColorBrush(Colors.Red);
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// OpenStatus property
        /// </summary>
        public bool OpenStatus
        {
            get
            {
                return _openStatus;
            }
            set
            {
                try
                {
                        _openStatus = value;
                        
                   
                }
                catch (Exception ex)
                {
                    
                    string strDbg = ex.Message;
                    
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// ProblemID property
        /// </summary>
        public int ProblemID
        {
            get
            {
                return _problemID;
            }
            set
            {
                try
                {
                    if (value > 0) // assume we have 7 departments
                    {
                        _problemID = value;
                        _rules.MaintainRule("problemid", false); // remove from collection
                        PropertyColors["problemid"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("problemid", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["problemid"] = new SolidColorBrush(Colors.Red);
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// TechID property
        /// </summary>
        public int TechID
        {
            get
            {
                return _techID;
            }
            set
            {
                try
                {
                    if (value > 0) // assume we have 7 departments
                    {
                        _techID = value;
                        _rules.MaintainRule("techid", false); // remove from collection
                        PropertyColors["techid"] = new SolidColorBrush(Colors.Black);
                    }
                    else
                        throw new System.Exception(); //caught below
                }
                catch (Exception ex)
                {
                    _rules.MaintainRule("techid", true); // add or replace in collection
                    string strDbg = ex.Message;
                    PropertyColors["techid"] = new SolidColorBrush(Colors.Red);
                }//end catch
            }//end setter
        }//end method

        /// <summary>
        /// TechID property
        /// </summary>
        public bool OpenStatus
        {
            get
            {
                return _openStatus;
            }
            set
            {
                try
                {
                    
                        _openStatus = value;
                        
                   
                }
                catch (Exception ex)
                {
                    
                    string strDbg = ex.Message;
                    
                }//end catch
            }//end setter
        }//end method

        public void CallRulesBroken(bool blnIsBroken)
        {
            if (evntEmployeeStillBroken != null)
                evntEmployeeStillBroken(blnIsBroken);  // raise event for presentation layer
        }

         public CallBusinessUser()
        {
            _rules = new BrokenRules();
            _rules.evntStillBroken += new RuleBrokenEventHandler(CallRulesBroken);
            // break all the rules
            _rules.MaintainRule("employeeid", true);
            _rules.MaintainRule("techid", true);
            _rules.MaintainRule("problemid", true);
            _rules.MaintainRule("notes", true);
            _rules.MaintainRule("dateopened", true);            

            PropertyColors = new Dictionary<string, SolidColorBrush>();
            PropertyColors["employeeid"] = new SolidColorBrush(Colors.Red);
            PropertyColors["techid"] = new SolidColorBrush(Colors.Red);
            PropertyColors["problemid"] = new SolidColorBrush(Colors.Red);
            PropertyColors["notes"] = new SolidColorBrush(Colors.Red);
            PropertyColors["dateopened"] = new SolidColorBrush(Colors.Red);            
        }//end constructor

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
             CallDataReference.CallDataServiceClient busData;
             int empID = -1;

             try
             {
                 Dictionary<string, object> createDictionary = new Dictionary<string, object>();
                 createDictionary["employeeid"] = _employeeID;
                 createDictionary["techid"] = _techID;
                 createDictionary["problemid"] = _problemID;
                 createDictionary["notes"] = _notes;
                 createDictionary["dateopened"] = _dateOpened;
                 createDictionary["dateclosed"] = _dateClosed;
                 createDictionary["openstatus"] = _openStatus;
                 

                 busData = new CallDataReference.CallDataServiceClient();
                 byte[] byteArray = ConfigBusinessUser.Serializer(createDictionary);
                 empID = busData.Create(byteArray);

             }

             catch (Exception ex)
             {
                 ConfigBusinessUser.ErrorRoutine(ex, "EmployeeBusinessUser", "Create");
             }

             return empID;
         }





         public int Delete(int empID)
         {
             int rowsDeleted = -1;

             CallDataReference.CallDataServiceClient busData;

             try
             {
                 busData = new CallDataReference.CallDataServiceClient();
                 rowsDeleted = busData.Delete(empID);
             }

             catch (Exception ex)
             {
                 ConfigBusinessUser.ErrorRoutine(ex, "EmployeeBusinessUser", "Delete");
             }


             return rowsDeleted;
         }



         public void GetByID(int empid)
         {
             CallDataReference.CallDataServiceClient empData;

             try //employeeID must be set by client before running this method
             {
                 empData = new CallDataReference.CallDataServiceClient();


                 Dictionary<string, Object> DictionaryEmployee = (Dictionary<string, Object>)ConfigBusinessUser.Deserializer(empData.GetByID(empid));
                 _employeeID = (int)DictionaryEmployee["employeeid"];
                 _techID = (int)DictionaryEmployee["techid"];
                 _openStatus = (bool)DictionaryEmployee["openstatus"];
                 _dateOpened = (DateTime)DictionaryEmployee["dateopened"];
                 _dateClosed = (DateTime)DictionaryEmployee["dateclosed"];
                 _notes = (byte[])DictionaryEmployee["notes"];
                 _problemID = (int)DictionaryEmployee["problemid"];
                 _entity = (byte[])DictionaryEmployee["entity"];

             }
             catch (Exception ex)
             {
                 ConfigBusinessUser.ErrorRoutine(ex, "EmployeeBusinessUser", "GetByID");
             }

         }//end GetById

         public int Update()
         {
             int rowsUpdated = -1;
             CallDataReference.CallDataServiceClient busData;

             try
             {
                 Dictionary<string, object> updateDictionary = new Dictionary<string, object>();
                 updateDictionary["techid"] = _techID;
                 updateDictionary["problemid"] = _problemID;
                 updateDictionary["employeeid"] = _employeeID;
                 updateDictionary["entity"] = _entity;
                 updateDictionary["dateclosed"] = _dateClosed;
                 updateDictionary["dateopened"] = _dateOpened;
                 updateDictionary["notes"] = _notes;
                 updateDictionary["openstatus"] = _openStatus;

                 busData = new CallDataReference.CallDataServiceClient();
                 byte[] updateArray = ConfigBusinessUser.Serializer(updateDictionary);
                 rowsUpdated = busData.Update(updateArray);
             }
             catch (Exception ex)
             {
                 ConfigBusinessUser.ErrorRoutine(ex, "CallBusinessUser", "Update");
             }

             return rowsUpdated;

         }//end Update method


         public List<CallBusinessUser> GetAll(string inputString)
         {
             CallDataReference.CallDataServiceClient busData;
             List<CallBusinessUser> businessUserList = new List<CallBusinessUser>();

             try
             {
                 busData = new CallDataReference.CallDataServiceClient();
                 CallDataReference.SerializedCall[] empdata = busData.GetAll(inputString);

                 foreach (CallDataReference.SerializedCall emp in empdata)
                 {
                     CallBusinessUser empBus = new CallBusinessUser();
                     empBus.loadDefaultValues();
                     empBus.CallID = emp.CallID;
                     //depBus.Department = depBus.Department.DepartmentName;
                     empBus.EmployeeID = emp.EmployeeID;
                     empBus.ProblemID = emp.ProblemID;
                     empBus.DateOpened = emp.DateOpened;
                     empBus.DateClosed = (DateTime)emp.DateClosed;
                     empBus.Notes = emp.Notes;                                     
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

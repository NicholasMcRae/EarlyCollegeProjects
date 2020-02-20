using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace HelpdeeskDataServices
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "CallDataService" in both code and config file together.
    public class CallDataService : ICallDataService
    {

        public int Update(byte[] bytEmployee)
        {
            int rowsUpdated = -1;

            try
            {
                HelpDeskDBEntities dbContext = new HelpDeskDBEntities();
                Dictionary<string, Object> DictionaryEmployee = (Dictionary<string, Object>)ConfigBusinessData.Deserializer(bytEmployee);
                byte[] ByteArrayEmployeeEntity = (byte[])DictionaryEmployee["entity"];
                Call EmployeeEntity = (Call)ConfigBusinessData.Deserializer(ByteArrayEmployeeEntity);
                dbContext.Calls.Attach(EmployeeEntity); //attach to the context and update fields
                EmployeeEntity.ProblemID = Convert.ToInt32(DictionaryEmployee["problemid"]);
                EmployeeEntity.EmployeeID = Convert.ToInt32(DictionaryEmployee["employeeid"]);
                EmployeeEntity.TechID = Convert.ToInt32(DictionaryEmployee["techid"]);
                EmployeeEntity.DateClosed = Convert.ToDateTime(DictionaryEmployee["dateclosed"]);
                EmployeeEntity.DateOpened = Convert.ToDateTime(DictionaryEmployee["dateopened"]);
                EmployeeEntity.Notes = (byte[])(DictionaryEmployee["notes"]);
                EmployeeEntity.OpenStatus = Convert.ToBoolean(DictionaryEmployee["openstatus"]);
                //EmployeeEntity.DepartmentID = Convert.ToInt32(DictionaryEmployee["departmentid"]);
                rowsUpdated = dbContext.SaveChanges(); //persist changes here
                dbContext.Detach(EmployeeEntity); //once detached, the sources can be garbage collected
            }
            //catch (OptimisticConcurrencyException ex)
            //{
            //    System.Diagnostics.Debug.Write(ex.Message);
            //    throw new Exception("Concurrency");
            //}
            catch (Exception ex)
            {
                throw ex;
            }
            return rowsUpdated;
        }//end update method


        public byte[] GetByID(int empid)
        {
            Dictionary<string, Object> retDictionary = new Dictionary<string, Object>();

            try //employeeID must be set by client before running this method
            {
                HelpDeskDBEntities dbContext = new HelpDeskDBEntities();
                Call empData = dbContext.Calls.FirstOrDefault(emp => emp.CallID == empid);
                if (empData != null)
                {
                    retDictionary["problemid"] = empData.ProblemID;
                    retDictionary["employeeid"] = empData.EmployeeID;
                    retDictionary["techid"] = empData.TechID;
                    retDictionary["dateclosed"] = empData.DateClosed;
                    retDictionary["dateopened"] = empData.DateOpened;
                    //retDictionary["departmentid"] = empData.DepartmentID;
                    retDictionary["notes"] = empData.Notes;
                    retDictionary["openstatus"] = empData.OpenStatus;
                    retDictionary["entity"] = ConfigBusinessData.Serializer(empData);
                    dbContext.Detach(empData);
                }
                else
                    retDictionary["error"] = "Employee Not Found!";
            }
            catch (Exception ex)
            {
                ConfigBusinessData.ErrorRoutine(ex, "EmployeeBusinessData", "Create");
                //throw new Exception(ex.Message); //should be caught by caller
            }
            byte[] dictionaryArray = ConfigBusinessData.Serializer(retDictionary);
            return dictionaryArray;

        }//end GetByID

        public int Delete(int empid)
        {
            int rowsDeleted = -1;

            try
            {
                HelpDeskDBEntities dbContext = new HelpDeskDBEntities();
                Call EmployeeEntity = dbContext.Calls.FirstOrDefault(emp => emp.CallID == empid);
                int rowsBeforeDeleted = dbContext.Calls.Count();
                dbContext.Calls.DeleteObject(EmployeeEntity);
                dbContext.SaveChanges();
                int rowsAfterDeleted = dbContext.Employees.Count();
                rowsDeleted = rowsBeforeDeleted - rowsAfterDeleted; //count should be 1 now
            }
            catch (Exception ex)
            {
                ConfigBusinessData.ErrorRoutine(ex, "EmployeeBusinessData", "Delete");
            }
            return rowsDeleted;
        }//end delete

        public int Create(byte[] ByteArrayEmp)
        {
            int newId = -1;
            Call EmployeeEntity = new Call();
            Dictionary<string, Object> DictionaryEmployee = (Dictionary<string, Object>)ConfigBusinessData.Deserializer(ByteArrayEmp);
            HelpDeskDBEntities dbContext = new HelpDeskDBEntities();
            try
            {
                EmployeeEntity.ProblemID = Convert.ToInt32(DictionaryEmployee["problemid"]);
                EmployeeEntity.EmployeeID = Convert.ToInt32(DictionaryEmployee["employeeid"]);
                EmployeeEntity.TechID = Convert.ToInt32(DictionaryEmployee["techid"]);
                EmployeeEntity.DateClosed = Convert.ToDateTime(DictionaryEmployee["dateclosed"]);
                EmployeeEntity.DateOpened = Convert.ToDateTime(DictionaryEmployee["dateopened"]);
                EmployeeEntity.Notes = (byte[])(DictionaryEmployee["notes"]);
                EmployeeEntity.OpenStatus = Convert.ToBoolean(DictionaryEmployee["openstatus"]);
                dbContext.AddToCalls(EmployeeEntity);
                dbContext.SaveChanges();
                newId = EmployeeEntity.CallID;
                dbContext.Detach(EmployeeEntity);
            }
            catch (Exception ex)
            {
                ConfigBusinessData.ErrorRoutine(ex, "EmployeeBusinessData", "Create");
            }

            return newId;
        }//end Create method

        public List<SerializedCall> GetAll(string inputString)
        {
            HelpDeskDBEntities dbContext = new HelpDeskDBEntities();
            List<SerializedCall> calls = new List<SerializedCall>();
            List<SerializedCall> busEmployees = new List<SerializedCall>();

            try
            {

                if (inputString == "all")
                {
                    foreach (Call emp in dbContext.Calls)
                    {
                        SerializedCall empBus = new SerializedCall();
                        //Department depBus = new Department();
                        //emp.DepartmentReference.Load();
                        //depBus.DepartmentName = emp.Department.DepartmentName;
                        empBus.CallID = emp.CallID;
                        empBus.EmployeeID = emp.EmployeeID;
                        empBus.ProblemID = emp.ProblemID;
                        empBus.DateOpened = emp.DateOpened;
                        empBus.DateClosed = emp.DateClosed;
                        empBus.Notes = emp.Notes;
                        empBus.Timer = emp.Timer;
                        busEmployees.Add(empBus);

                    }//end foreach
                }
                if (inputString == "open")
                {
                    var employee = dbContext.Calls.Where(emp => emp.DateOpened != null);

                    foreach (Call emp in employee)
                    {
                        SerializedCall empBus = new SerializedCall();
                        //Department depBus = new Department();
                        //emp.DepartmentReference.Load();
                        //depBus.DepartmentName = emp.Department.DepartmentName;
                        empBus.CallID = emp.CallID;
                        empBus.EmployeeID = emp.EmployeeID;
                        empBus.ProblemID = emp.ProblemID;
                        empBus.DateOpened = emp.DateOpened;
                        empBus.DateClosed = emp.DateClosed;
                        empBus.Notes = emp.Notes;
                        empBus.Timer = emp.Timer;
                        busEmployees.Add(empBus);

                    }//end foreach
                }
            }//end try
            catch (Exception ex)
            {
                ConfigBusinessData.ErrorRoutine(ex, "EmployeeBusinessData", "Create");
                //throw new Exception(ex.Message);
            }
            return busEmployees;
        }//End method

    }
}

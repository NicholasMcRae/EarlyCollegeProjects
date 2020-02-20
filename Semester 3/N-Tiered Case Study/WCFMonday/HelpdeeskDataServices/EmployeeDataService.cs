using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace HelpdeeskDataServices
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "EmployeeDataService" in both code and config file together.
    public class EmployeeDataService : IEmployeeDataService
    {
        public int Create(byte[] ByteArrayEmp)
        {
            int newId = -1;
            Employee EmployeeEntity = new Employee();
            Dictionary<string, Object> DictionaryEmployee = (Dictionary<string, Object>)ConfigBusinessData.Deserializer(ByteArrayEmp);
            HelpDeskDBEntities dbContext = new HelpDeskDBEntities();
            try
            {
                EmployeeEntity.Title = Convert.ToString(DictionaryEmployee["title"]);
                EmployeeEntity.FirstName = Convert.ToString(DictionaryEmployee["firstname"]);
                EmployeeEntity.LastName = Convert.ToString(DictionaryEmployee["lastname"]);
                EmployeeEntity.PhoneNo = Convert.ToString(DictionaryEmployee["phoneno"]);
                EmployeeEntity.Email = Convert.ToString(DictionaryEmployee["email"]);
                EmployeeEntity.DepartmentID = Convert.ToInt32(DictionaryEmployee["departmentid"]);
                dbContext.AddToEmployees(EmployeeEntity);
                dbContext.SaveChanges();
                newId = EmployeeEntity.EmployeeID;
                dbContext.Detach(EmployeeEntity);
            }
            catch (Exception ex)
            {
                ConfigBusinessData.ErrorRoutine(ex, "EmployeeBusinessData", "Create");
            }

            return newId;
        }//end Create method

        /// <summary>
        /// 
        /// </summary>
        /// <param name="bytEmployee"></param>
        /// <returns>an int with the number of rows updated</returns>
        /// writes some code that saves changes and returns the number of rows that were updated

        public int Update(byte[] bytEmployee)
        {
            int rowsUpdated = -1;

            try
            {
                HelpDeskDBEntities dbContext = new HelpDeskDBEntities();
                Dictionary<string, Object> DictionaryEmployee = (Dictionary<string, Object>)ConfigBusinessData.Deserializer(bytEmployee);
                byte[] ByteArrayEmployeeEntity = (byte[])DictionaryEmployee["entity"];
                Employee EmployeeEntity = (Employee)ConfigBusinessData.Deserializer(ByteArrayEmployeeEntity);
                dbContext.Employees.Attach(EmployeeEntity); //attach to the context and update fields
                EmployeeEntity.Title = Convert.ToString(DictionaryEmployee["title"]);
                EmployeeEntity.FirstName = Convert.ToString(DictionaryEmployee["firstname"]);
                EmployeeEntity.LastName = Convert.ToString(DictionaryEmployee["lastname"]);
                EmployeeEntity.PhoneNo = Convert.ToString(DictionaryEmployee["phoneno"]);
                EmployeeEntity.Email = Convert.ToString(DictionaryEmployee["email"]);
                EmployeeEntity.DepartmentID = Convert.ToInt32(DictionaryEmployee["departmentid"]);
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

        ///<summary>
        ///<param name= "empid"> int representing employee </param>
        ///<returns> serialized Dictionary containing single employee info</returns>
        ///</summary>
        ///this method pulls out the employee id  returned by the last method, creates a dictionary, and returns the serialized dictionary
        public byte[] GetByID(int empid)
        {
            Dictionary<string, Object> retDictionary = new Dictionary<string, Object>();

            try //employeeID must be set by client before running this method
            {
                HelpDeskDBEntities dbContext = new HelpDeskDBEntities();
                Employee empData = dbContext.Employees.FirstOrDefault(emp => emp.EmployeeID == empid);
                if (empData != null)
                {
                    retDictionary["title"] = empData.Title;
                    retDictionary["firstname"] = empData.FirstName;
                    retDictionary["lastname"] = empData.LastName;
                    retDictionary["phoneno"] = empData.PhoneNo;
                    retDictionary["email"] = empData.Email;
                    retDictionary["departmentid"] = empData.DepartmentID;
                    retDictionary["emp"] = empData.EmployeeID;
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
                Employee EmployeeEntity = dbContext.Employees.FirstOrDefault(emp => emp.EmployeeID == empid);
                int rowsBeforeDeleted = dbContext.Employees.Count();
                dbContext.Employees.DeleteObject(EmployeeEntity);
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

        public List<SerializeEmployee> GetAll()
        {
            HelpDeskDBEntities dbContext = new HelpDeskDBEntities();
            List<SerializeEmployee> employees = new List<SerializeEmployee>();
            List<SerializeEmployee> busEmployees = new List<SerializeEmployee>();
            
            try
            {
                foreach (Employee emp in dbContext.Employees)
                {
                    SerializeEmployee empBus = new SerializeEmployee();
                    //Department depBus = new Department();
                    //emp.DepartmentReference.Load();
                    //depBus.DepartmentName = emp.Department.DepartmentName;
                    empBus.EmployeeID = emp.EmployeeID;
                    empBus.FirstName = emp.FirstName;
                    empBus.LastName = emp.LastName;
                    empBus.PhoneNo = emp.PhoneNo;
                    empBus.Email = emp.Email;
                    empBus.DepartmentID = emp.DepartmentID;
                    busEmployees.Add(empBus);

                }//end foreach
            }//end try
            catch (Exception ex)
            {
                ConfigBusinessData.ErrorRoutine(ex, "EmployeeBusinessData", "Create");
                //throw new Exception(ex.Message);
            }
            return busEmployees;
        }//End method


        public List<SerializeEmployee> GetAllTechs()
        {
            HelpDeskDBEntities dbContext = new HelpDeskDBEntities();
            List<SerializeEmployee> employees = new List<SerializeEmployee>();
            List<SerializeEmployee> busEmployees = new List<SerializeEmployee>();

            var employee = dbContext.Employees.Where(emp => emp.IsTech == true);

            try
            {
                foreach (Employee emp in employee)
                {
                    SerializeEmployee empBus = new SerializeEmployee();
                    empBus.EmployeeID = emp.EmployeeID;
                    empBus.FirstName = emp.FirstName;
                    empBus.LastName = emp.LastName;
                    empBus.PhoneNo = emp.PhoneNo;
                    empBus.Email = emp.Email;
                    empBus.DepartmentID = emp.DepartmentID;
                    busEmployees.Add(empBus);

                }//end foreach
            }//end try
            catch (Exception ex)
            {
                ConfigBusinessData.ErrorRoutine(ex, "EmployeeBusinessData", "Create");
                //throw new Exception(ex.Message);
            }
            return busEmployees;
        }//End method


    }//end class
}//end namespace

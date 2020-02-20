using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.IO;
using System.Data;

namespace ExerciseObjects
{
    /// <summary>
    /// delegates used for employee object events
    /// </summary>
    /// <param name="bFoundDepartment"></param>
    public delegate void DepartmentFoundEventHandler(bool bFoundDepartment); //template for event

    public delegate void DepartmentFoundEventHandlerTwo(bool bFoundDepartment, string lastName);//second template

    /// <summary>
    /// The Business object representing an Employee
    /// </summary>
    public class EmployeeBusiness
    {
        ///<summary>
        ///department events
        /// </summary>
        public event DepartmentFoundEventHandler FoundDepartment;
        public event DepartmentFoundEventHandlerTwo FoundDepartmentAndName;

        //private members
        private int _age;
        private int _employeeID;
        private string _departmentName;
        private string _firstName;
        private string _lastName;
        private byte[] _entity;
             


        /// <summary>
        /// Age Property - int
        /// </summary>
        public int Age
        {
            get { return _age; }
            set { _age = value; }
        }
        /// <summary>
        /// EmployeeID Property - int
        /// </summary>
        public int EmployeeID
        {
            get { return _employeeID; }
            set { _employeeID = value; }
        }
        ///<summary>
        /// DepartmentName Property - string
        /// </summary>
        public string DepartmentName
        {
            get { return _departmentName; }
            set { _departmentName = value; }
        }

        ///<summary>
        ///FirstName Property - string
        ///</summary>
        public string FirstName
        {
            get { return _firstName; }
            set { _firstName = value; }
        }
        /// <summary>
        /// LastName Property - string
        /// </summary>
        public string LastName
        {
            get { return _lastName; }
            set { _lastName = value; }
        }

        /// <summary>
        /// constructor
        /// </summary>
        public EmployeeBusiness() { }

        ///<summary>
        ///business method to determine year person was born in
        ///<returns> An int representing the year of bird </returns>
        ///</summary>
        public int CalculateBirthYear()
        {
            return DateTime.Now.Year - _age;
        }

        public void GetEmployeeDept()
        {
            try
            {

                HelpDeskDBEntities1 dbContext = new HelpDeskDBEntities1();

                System.Nullable<int> empid = _employeeID;

                //Output parameters - need to be of ObjectParameter type
                var deptName = new System.Data.Objects.ObjectParameter("deptName", typeof(string));
                var empSurname = new System.Data.Objects.ObjectParameter("empSurname", typeof(string));
                var deptID = new System.Data.Objects.ObjectParameter("deptID", typeof(int));

                deptID.Value = -1;
                dbContext.GetInfoLabSix(empid, deptName, empSurname, deptID);//method call loads output parameters

                if (_employeeID > 0)
                {
                    _departmentName = Convert.ToString(deptName.Value);
                    _lastName = Convert.ToString(empSurname.Value);
                    FoundDepartment(true); //raise event - found employee
                }
                else
                {
                    _lastName = "not found";
                    FoundDepartment(false); //raise event - didn't find employee
                }
            }//end try
            catch (Exception ex)
            {
                throw new Exception(ex.Message); //should be caught by caller
            }
            


                     

                             
                                       
        }// end method

        public void GetEmployeeDeptAndName()
        {
            try
            {

                HelpDeskDBEntities1 dbContext = new HelpDeskDBEntities1();

                
                System.Nullable<int> empid = _employeeID;

                //Output parameters - need to be of ObjectParameter type
                var deptName = new System.Data.Objects.ObjectParameter("deptName", typeof(string));
                var empSurname = new System.Data.Objects.ObjectParameter("empSurname", typeof(string));
                var deptID = new System.Data.Objects.ObjectParameter("deptID", typeof(int));

                deptID.Value = -1;
                dbContext.GetInfoLabSix(empid, deptName, empSurname, deptID);//method call loads output parameters

                if (Convert.ToInt32(deptID.Value) > 0)
                {
                    _departmentName = Convert.ToString(deptName.Value);
                    _lastName = Convert.ToString(empSurname.Value);
                    FoundDepartmentAndName(true, _lastName); //raise event - found employee
                }
                else
                {
                    _lastName = "not found";
                    FoundDepartmentAndName(false, null); //raise event - didn't find employee
                }
            }//end try
            catch (Exception ex)
            {
                throw new Exception(ex.Message); //should be caught by caller
            }

            


        }// end method

        public List<EmployeeBusiness> GetAllEmployees()
        {
            HelpDeskDBEntities1 dbContext = new HelpDeskDBEntities1();
            List<Employee> employees = dbContext.Employees.ToList();
            List<EmployeeBusiness> busEmployees = new List<EmployeeBusiness>();
            try
            {
                foreach (Employee emp in employees)
                {
                    EmployeeBusiness empBus = new EmployeeBusiness();
                    emp.DepartmentReference.Load();
                    empBus.DepartmentName = emp.Department.DepartmentName;
                    empBus.EmployeeID = emp.EmployeeID;
                    empBus.FirstName = emp.FirstName;
                    empBus.LastName = emp.LastName;
                    busEmployees.Add(empBus);

                }//end foreach
            }//end try
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            return busEmployees;
        }//End method


        public Dictionary<string, object> GetAnEmployee()
        {                        
            try
            {
                HelpDeskDBEntities1 dbContext = new HelpDeskDBEntities1();
                System.Nullable<int> empid = _employeeID;
                Dictionary<string, object> dictionaryEmployee = new Dictionary<string, object>();                

                //lambda uses inline function, also use explicit Employee type
                Employee employee = dbContext.Employees.FirstOrDefault(emp => emp.EmployeeID == empid);

                if (employee != null)
                {                    
                    dictionaryEmployee.Add("title", employee.Title.ToString());
                    dictionaryEmployee.Add("first", employee.FirstName.ToString());
                    dictionaryEmployee.Add("last", employee.LastName.ToString());
                    dictionaryEmployee.Add("email", employee.Email.ToString());
                    dictionaryEmployee.Add("dept", employee.DepartmentID.ToString());                    
                }
                else
                {
                    dictionaryEmployee.Add("error", empid);
                    return dictionaryEmployee;
                }                 
                
                return dictionaryEmployee;
            }

            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }

            
        }//end GetAnEmployee

        public Dictionary<string, Object> GetAnEmployeeForConcurrency()
        {
            Dictionary<string, Object> retDictionary = new Dictionary<string, Object>();

            try //employeeID must be set by client before running this method
            {
                HelpDeskDBEntities1 dbContext = new HelpDeskDBEntities1();
                Employee empData = dbContext.Employees.FirstOrDefault(emp => emp.EmployeeID == _employeeID);
                if (empData != null)
                {
                    retDictionary["title"] = empData.Title;
                    retDictionary["first"] = empData.FirstName;
                    retDictionary["last"] = empData.LastName;
                    retDictionary["phone"] = empData.PhoneNo;
                    retDictionary["email"] = empData.Email;
                    retDictionary["dep"] = empData.DepartmentID;
                    retDictionary["emp"] = empData.EmployeeID;
                    BinaryFormatter formatter = new BinaryFormatter();
                    MemoryStream stream = new MemoryStream();
                    formatter.Serialize(stream, empData); //need to serialize current entity (will be updated)
                    _entity = stream.ToArray();
                    dbContext.Detach(empData);
                }
                else
                    retDictionary["error"] = "Employee Not Found!";
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message); //should be caught by caller
            }
            return retDictionary;

        }//end GetAnEmployeeForConcurrency


        public int UpdateEmployee(Dictionary<string, Object> empDictionary)
        {
            int rowsUpdated = -1;
            try
            {
                HelpDeskDBEntities1 dbContext = new HelpDeskDBEntities1();
                BinaryFormatter formatter = new BinaryFormatter();
                MemoryStream stream = new MemoryStream(_entity);
                Employee empData = (Employee)formatter.Deserialize(stream); //deserialize here
                dbContext.Employees.Attach(empData); //attach to the context and update fields
                empData.Title = Convert.ToString(empDictionary["title"]);
                empData.FirstName = Convert.ToString(empDictionary["first"]);
                empData.LastName = Convert.ToString(empDictionary["last"]);
                empData.PhoneNo = Convert.ToString(empDictionary["phone"]);
                empData.Email = Convert.ToString(empDictionary["email"]);
                empData.DepartmentID = Convert.ToInt32(empDictionary["dep"]);
                rowsUpdated = dbContext.SaveChanges(); //persist changes here
                dbContext.Detach(empData); //once detached, the sources can be garbage collected
            }
            catch (OptimisticConcurrencyException ex)
            {
                System.Diagnostics.Debug.Write(ex.Message);
                throw new Exception("Concurrency");
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return rowsUpdated;

        }//end UpdateEmployee


        

        






    }//end class
}//end namespace

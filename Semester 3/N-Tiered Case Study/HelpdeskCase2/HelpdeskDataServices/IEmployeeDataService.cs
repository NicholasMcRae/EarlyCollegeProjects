using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace HelpdeskDataServices
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IEmployeeDataService" in both code and config file together.
    [ServiceContract]
    public interface IEmployeeDataService
    {
        [OperationContract]
        int Create(byte[] ByteArrayEmp);
        [OperationContract]
        int Update(byte[] bytEmployee);
        [OperationContract]
        byte[] GetByID(int empid);
        [OperationContract]
        int Delete(int empid);
        [OperationContract]
        List<SerializedEmployee> GetAll();
        [OperationContract]
        List<SerializedEmployee> GetAllTechs();
    }
}

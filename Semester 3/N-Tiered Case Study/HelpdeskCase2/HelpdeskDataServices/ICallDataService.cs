using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace HelpdeskDataServices
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ICallDataService" in both code and config file together.
    [ServiceContract]
    public interface ICallDataService
    {
        [OperationContract]
        int Update(byte[] bytCall);
        [OperationContract]
        byte[] GetByID(int callid);
        [OperationContract]
        int Delete(int callid);
        [OperationContract]
        int Create(byte[] bytCall);
        [OperationContract]
        List<SerializedCall> GetAll(string set);
    }
}

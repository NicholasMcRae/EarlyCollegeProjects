using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Diagnostics;
using System.Runtime.Serialization.Formatters.Binary;
using System.Runtime.Serialization;
using System.IO;


namespace HelpdeeskDataServices
{
    public class ConfigBusinessData
    {
        /// <summary>
        /// Static error routine to be used by all methods
        /// </summary>
        /// <param name "e">Exception</param>
        /// <param name="obj">Class name throwing exception</param>

        public static void ErrorRoutine(Exception e, string obj, string method)
        {
            //create log and source with logcreator app before using this method
            EventLog log = new EventLog();
            log.Source = "Help Desk Application";
            log.Log = "Help Desk";

            if (e.InnerException != null)
            {
                log.WriteEntry("Error in HelpdeskDataObjects, object=" + obj +
                    ", method=" + method + " , inner exception message=" +
                    e.InnerException.Message, EventLogEntryType.Error);
                throw e.InnerException;
            }
            else
            {
                log.WriteEntry("Error in HelpdeskDataObjects, objects=" + obj +
                    ", method=" + method + " , message=" + e.Message, EventLogEntryType.Error);

                throw e;
            }
        }//end Error Routine

        ///<summary>
        ///Serializer
        ///</summary>
        ///<param name="inObject">Object to be serialized</param>
        ///<returns>Serialized Object in Byte Array</returns>
        public static byte[] Serializer(Object inObject)
        {
            BinaryFormatter frm = new BinaryFormatter();
            MemoryStream strm = new MemoryStream();
            frm.Serialize(strm, inObject);
            byte[] ByteArrayObject = strm.ToArray();
            return ByteArrayObject;
        }

        /// <summary>
        /// Deserializer
        /// </summary>
        /// <param name="ByteArrayIn">Serialized Object from BusinessUser Layer</param>
        /// <returns>Reconstructed Object</Returns>
        public static Object Deserializer(byte[] ByteArrayIn)
        {
            BinaryFormatter frm = new BinaryFormatter();
            MemoryStream strm = new MemoryStream(ByteArrayIn);
            Object returnObject = frm.Deserialize(strm);
            return returnObject;
        }

    }
}

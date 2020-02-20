﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.17929
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace HelpdeskBusinessUserObjects.CallDataReference {
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="SerializedCall", Namespace="http://schemas.datacontract.org/2004/07/HelpdeskDataServices", IsReference=true)]
    [System.SerializableAttribute()]
    public partial class SerializedCall : HelpdeskBusinessUserObjects.CallDataReference.ComplexObject {
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int CallIDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private System.Nullable<System.DateTime> DateClosedField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private System.DateTime DateOpenedField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int EmployeeIDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private byte[] NotesField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private System.Nullable<bool> OpenStatusField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int ProblemIDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int TechIDField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private byte[] TimerField;
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int CallID {
            get {
                return this.CallIDField;
            }
            set {
                if ((this.CallIDField.Equals(value) != true)) {
                    this.CallIDField = value;
                    this.RaisePropertyChanged("CallID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public System.Nullable<System.DateTime> DateClosed {
            get {
                return this.DateClosedField;
            }
            set {
                if ((this.DateClosedField.Equals(value) != true)) {
                    this.DateClosedField = value;
                    this.RaisePropertyChanged("DateClosed");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public System.DateTime DateOpened {
            get {
                return this.DateOpenedField;
            }
            set {
                if ((this.DateOpenedField.Equals(value) != true)) {
                    this.DateOpenedField = value;
                    this.RaisePropertyChanged("DateOpened");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int EmployeeID {
            get {
                return this.EmployeeIDField;
            }
            set {
                if ((this.EmployeeIDField.Equals(value) != true)) {
                    this.EmployeeIDField = value;
                    this.RaisePropertyChanged("EmployeeID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public byte[] Notes {
            get {
                return this.NotesField;
            }
            set {
                if ((object.ReferenceEquals(this.NotesField, value) != true)) {
                    this.NotesField = value;
                    this.RaisePropertyChanged("Notes");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public System.Nullable<bool> OpenStatus {
            get {
                return this.OpenStatusField;
            }
            set {
                if ((this.OpenStatusField.Equals(value) != true)) {
                    this.OpenStatusField = value;
                    this.RaisePropertyChanged("OpenStatus");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int ProblemID {
            get {
                return this.ProblemIDField;
            }
            set {
                if ((this.ProblemIDField.Equals(value) != true)) {
                    this.ProblemIDField = value;
                    this.RaisePropertyChanged("ProblemID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int TechID {
            get {
                return this.TechIDField;
            }
            set {
                if ((this.TechIDField.Equals(value) != true)) {
                    this.TechIDField = value;
                    this.RaisePropertyChanged("TechID");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public byte[] Timer {
            get {
                return this.TimerField;
            }
            set {
                if ((object.ReferenceEquals(this.TimerField, value) != true)) {
                    this.TimerField = value;
                    this.RaisePropertyChanged("Timer");
                }
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="StructuralObject", Namespace="http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses", IsReference=true)]
    [System.SerializableAttribute()]
    [System.Runtime.Serialization.KnownTypeAttribute(typeof(HelpdeskBusinessUserObjects.CallDataReference.ComplexObject))]
    [System.Runtime.Serialization.KnownTypeAttribute(typeof(HelpdeskBusinessUserObjects.CallDataReference.SerializedCall))]
    public partial class StructuralObject : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="ComplexObject", Namespace="http://schemas.datacontract.org/2004/07/System.Data.Objects.DataClasses", IsReference=true)]
    [System.SerializableAttribute()]
    [System.Runtime.Serialization.KnownTypeAttribute(typeof(HelpdeskBusinessUserObjects.CallDataReference.SerializedCall))]
    public partial class ComplexObject : HelpdeskBusinessUserObjects.CallDataReference.StructuralObject {
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="CallDataReference.ICallDataService")]
    public interface ICallDataService {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICallDataService/Update", ReplyAction="http://tempuri.org/ICallDataService/UpdateResponse")]
        int Update(byte[] bytCall);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICallDataService/GetByID", ReplyAction="http://tempuri.org/ICallDataService/GetByIDResponse")]
        byte[] GetByID(int callid);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICallDataService/Delete", ReplyAction="http://tempuri.org/ICallDataService/DeleteResponse")]
        int Delete(int callid);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICallDataService/Create", ReplyAction="http://tempuri.org/ICallDataService/CreateResponse")]
        int Create(byte[] bytCall);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICallDataService/GetAll", ReplyAction="http://tempuri.org/ICallDataService/GetAllResponse")]
        HelpdeskBusinessUserObjects.CallDataReference.SerializedCall[] GetAll(string set);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface ICallDataServiceChannel : HelpdeskBusinessUserObjects.CallDataReference.ICallDataService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class CallDataServiceClient : System.ServiceModel.ClientBase<HelpdeskBusinessUserObjects.CallDataReference.ICallDataService>, HelpdeskBusinessUserObjects.CallDataReference.ICallDataService {
        
        public CallDataServiceClient() {
        }
        
        public CallDataServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public CallDataServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public CallDataServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public CallDataServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public int Update(byte[] bytCall) {
            return base.Channel.Update(bytCall);
        }
        
        public byte[] GetByID(int callid) {
            return base.Channel.GetByID(callid);
        }
        
        public int Delete(int callid) {
            return base.Channel.Delete(callid);
        }
        
        public int Create(byte[] bytCall) {
            return base.Channel.Create(bytCall);
        }
        
        public HelpdeskBusinessUserObjects.CallDataReference.SerializedCall[] GetAll(string set) {
            return base.Channel.GetAll(set);
        }
    }
}

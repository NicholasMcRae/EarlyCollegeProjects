Imports System.IO
Imports System.Runtime.Serialization.Formatters.Binary
Imports WCFClient.EmployeeDataReference

Class MainWindow

    Private Sub Button1_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button1.Click

        Dim DictionaryData As New Dictionary(Of String, Object)
        Dim outStr As String = ""

        Try

            Dim EmployeeBD As EmployeeDataReference.EmployeeDataServiceClient = _
                New EmployeeDataReference.EmployeeDataServiceClient
            DictionaryData("title") = "Mr."
            DictionaryData("firstname") = "John"
            DictionaryData("lastname") = "Smith"
            DictionaryData("phoneno") = "555-5555"
            DictionaryData("email") = "js@abc.com"
            DictionaryData("departmentid") = 100
            'Add employee, obtain generated PK
            Dim iEmplId As Integer = EmployeeBD.Create(Serializer(DictionaryData))
            outStr += "Employee Added - key = " & iEmplId & vbCrLf
            ' get employee just added
            DictionaryData = DeSerializer(EmployeeBD.GetByID(iEmplId))
            'update same employee with same data
            Dim rowsUpdated As Integer = EmployeeBD.Update(Serializer(DictionaryData))
            outStr += "Employee " & iEmplId & " update - rows updated " & rowsUpdated & vbCrLf
            ' delete same employee
            Dim rowsDeleted As Integer = EmployeeBD.Delete(iEmplId)
            outStr += "Employee " & iEmplId & " deleted rows " & rowsDeleted & vbCrLf
            ' get them all and display count
            Dim AllEmployees As SerializeEmployee() = EmployeeBD.GetAll()
            outStr += "There are " & AllEmployees.Count & " employees left in the DB" & vbCrLf
            Dim AllTechs As SerializeEmployee() = EmployeeBD.GetAllTechs()
            outStr += "There are " & AllTechs.Count & " techs in the DB" & vbCrLf
            MessageBox.Show(outStr, "Test EmployeeBusinessData Object", _
                            MessageBoxButton.OK, MessageBoxImage.Information)

        Catch ex As Exception
            MessageBox.Show("Problem doing EmployeeBusinessData routines", _
                            "check event viewer for details", _
                            MessageBoxButton.OK, MessageBoxImage.Error)

        End Try

    End Sub

    Private Function Serializer(ByVal inObject As Object) As Byte()
        Dim frm As BinaryFormatter = New BinaryFormatter()
        Dim strm As MemoryStream = New MemoryStream()
        frm.Serialize(strm, inObject)
        Dim ByteArrayObject As Byte() = strm.ToArray()
        Return ByteArrayObject
    End Function

    Private Function DeSerializer(ByVal ByteArrayIn As Byte()) As Object
        Dim frm As BinaryFormatter = New BinaryFormatter()
        Dim strm As MemoryStream = New MemoryStream(ByteArrayIn)
        Dim returnObject As Object = frm.Deserialize(strm)
        Return returnObject
    End Function

    Private Sub Button2_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button2.Click
        Dim DictionaryData As New Dictionary(Of String, Object)
        Dim outStr As String = ""
        Try
            Dim CallBD As CallDataReference.CallDataServiceClient = _
                New CallDataReference.CallDataServiceClient
            DictionaryData("problemid") = 1
            DictionaryData("employeeid") = 1
            DictionaryData("techid") = 7
            DictionaryData("dateclosed") = Now
            DictionaryData("dateopened") = Now
            'load a byte array
            Dim EncodedText As New System.Text.ASCIIEncoding
            Dim ByteArray() As Byte = EncodedText.GetBytes("abc")
            DictionaryData("notes") = ByteArray
            DictionaryData("openstatus") = False
            'Add call, obtain generated PK
            Dim iCallId As Integer = CallBD.Create(Serializer(DictionaryData))
            outStr += "Call Added - key = " & iCallId & vbCrLf
            'get call just added
            DictionaryData = DeSerializer(CallBD.GetByID(iCallId))
            outStr += "Call Retrieved - key = " & iCallId & vbCrLf
            'update same call with same data
            Dim rowsUpdated As Integer = CallBD.Update(Serializer(DictionaryData))
            outStr += "Call " & iCallId & " update - rows updated " & rowsUpdated & vbCrLf
            'delete same call
            Dim rowsDeleted As Integer = CallBD.Delete(iCallId)
            outStr += "Call " & iCallId & " deleted rows " & rowsDeleted & vbCrLf
            'get them all and display count
            Dim AllCalls As CallDataReference.SerializedCall() = CallBD.GetAll("all")
            outStr += "There are " & AllCalls.Count & " calls in the DB" & vbCrLf
            MessageBox.Show(outStr, "Test Remote CallDataReference Object", _
                            MessageBoxButton.OK, MessageBoxImage.Information)

        Catch ex As Exception
            MessageBox.Show("Problem doing Remote CallDataReference routines", _
                            "check event viewer for details", _
                            MessageBoxButton.OK, MessageBoxImage.Error)

        End Try
    End Sub
End Class

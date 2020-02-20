Imports HelpdeskBusinessUserObjects


Public Class CallTestDriver

    Dim _call As CallBusinessUser = New CallBusinessUser
    Dim callID As Integer
    Dim outStr As String
    Dim rowsUpdated As Integer

    Private Sub Button1_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button1.Click

        Try
            Dim memoryStream As System.IO.MemoryStream = New System.IO.MemoryStream()
            Dim textRange As TextRange = New TextRange(RichTextBox1.Document.ContentStart, RichTextBox1.Document.ContentEnd)
            textRange.Save(memoryStream, System.Windows.DataFormats.Rtf)
            Dim byteArray(memoryStream.Length()) As Byte
            byteArray = memoryStream.ToArray()
            With _call 'load up a _call for Create, don't place pictures here yet
                .DateOpened = Now.Date
                .DateClosed = Now.Date
                .EmployeeID = 1
                .OpenStatus = False
                .ProblemID = 1
                .TechID = 7
                .Notes = byteArray
                callID = .Create()
                outStr = "Call Added - key = " & callID
                .GetByID(callID)
                outStr += vbCrLf & " Call retrieved = " & callID
                textRange = New TextRange(RichTextBox2.Document.ContentStart, RichTextBox2.Document.ContentEnd)
                textRange.Load(New System.IO.MemoryStream(.Notes), DataFormats.Rtf)
                RichTextBox2.DataContext = textRange.Text
                rowsUpdated = .Update() 'update the table with the same call info
                outStr += vbCrLf & " Rows Updated = " & rowsUpdated
                Dim calls As List(Of CallBusinessUser) = _call.GetAll("all")
                outStr += vbCrLf & " Get All Calls = " & calls.Count()
                rowsUpdated = .Delete(callID)
                outStr += vbCrLf & " Call deleted = " & rowsUpdated
            End With

            MessageBox.Show(outStr, "Test Call User Object", _
                            MessageBoxButton.OK, MessageBoxImage.Information)

        Catch ex As Exception

            MessageBox.Show(ex.Message)

        End Try


    End Sub
End Class

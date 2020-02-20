Imports ExerciseObjects
Public Class WindowDictionaryExample2

    Private Sub Button1_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button1.Click
        Try
            Dim oEmp As EmployeeBusiness = New EmployeeBusiness
            oEmp.EmployeeID = Convert.ToInt32(textInput2.Text)
            Dim empDict As Dictionary(Of String, Object) = oEmp.GetAnEmployee


            If Not empDict.ContainsKey("error") Then

                MessageBox.Show("Title " & empDict("title") & vbCrLf & _
                                "First Name " & empDict("first") & vbCrLf & _
                                "Last Name " & empDict("last") & vbCrLf & _
                                "Email " & empDict("email") & vbCrLf & _
                                "Department " & empDict("dept"), "Dictionary Contents", _
                                MessageBoxButton.OK, MessageBoxImage.Information)

            Else
                MessageBox.Show("Employee " & textInput2.Text & " Not Found", _
                            "Error has occurred, no employee found", _
                            MessageBoxButton.OK, MessageBoxImage.Error)
            End If


        Catch ex As Exception
            MessageBox.Show("Error " & ex.Message, "Error has occurred", MessageBoxButton.OK, MessageBoxImage.Error)

        End Try
    End Sub
End Class
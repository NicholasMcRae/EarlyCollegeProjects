Imports ExerciseObjects

Public Class WindowConcurrencyExample
    Private empDictionary As Dictionary(Of String, Object)
    Private emp As EmployeeBusiness

    Private Sub Button1_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button1.Click
        Try
            emp = New EmployeeBusiness
            emp.EmployeeID = textID.Text
            empDictionary = emp.GetAnEmployeeForConcurrency()
            textBoxFirstName.Text = Convert.ToString(empDictionary("first"))
            textBoxLastName.Text = Convert.ToString(empDictionary("last"))
        Catch ex As Exception
            MessageBox.Show("Can't find Employee", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
        End Try


    End Sub

    Private Sub Button2_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button2.Click
        Try
            empDictionary("first") = textBoxFirstName.Text
            empDictionary("last") = textBoxLastName.Text

            If emp.UpdateEmployee(empDictionary) Then
                MessageBox.Show("Employee Updated!", "Update Valid", MessageBoxButton.OK, MessageBoxImage.Information)
            Else
                MessageBox.Show("Employee Not Updated!", "There was some other problem", MessageBoxButton.OK, MessageBoxImage.Information)
            End If
        Catch ex As Exception
            If ex.Message = "Concurrency" Then
                MessageBox.Show("Employee Not Updated! - Stale Data", "You need to retrieve a fresh copy and retry", MessageBoxButton.OK, MessageBoxImage.Information)
            Else
                MessageBox.Show("Employee Not Updated!", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
            End If

        End Try
       

    End Sub
End Class

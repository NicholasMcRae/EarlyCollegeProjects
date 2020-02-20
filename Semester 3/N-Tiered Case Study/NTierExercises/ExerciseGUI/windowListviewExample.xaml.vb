Imports ExerciseObjects

Public Class windowListviewExample

    Private Sub buttonLoad_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles buttonLoad.Click
        Try
            Dim oEmp As EmployeeBusiness = New EmployeeBusiness
            listViewNames.ItemsSource = oEmp.GetAllEmployees
        Catch ex As Exception
            MessageBox.Show("Problem loading List View", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
        End Try
    End Sub
End Class

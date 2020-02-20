Imports ExerciseObjects

Public Class windowMainMenu


    Private Sub menuItemEmployeeView_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles menuItemEmployeeView.Click
        Try
            Dim winLV As windowListviewExample = New windowListviewExample
            winLV.Show()
        Catch ex As Exception
            MessageBox.Show("Problem trying to display employee!", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
        End Try
    End Sub

    Private Sub MenuItemFile_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles MenuItemFile.Click
        Me.Close()
        Application.Current.Shutdown()
    End Sub

    'Private Sub menuItemEmployeeGroup_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles menuItemEmployeeGroup.Click
    '    Try
    '        Dim oEmp As EmployeeBusiness = New EmployeeBusiness
    '        listViewNames.ItemsSource = oEmp.GetAllEmployees
    '    Catch ex As Exception
    '        MessageBox.Show("Problem loading list View", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error

    '    End Try
    'End Sub
End Class

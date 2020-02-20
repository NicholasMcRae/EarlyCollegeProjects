Imports HelpdeskBusinessUserObjects
Imports HelpdeskUserControls

Public Class windowMainMenu

    Private Sub menuItemEmployeeView_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles menuItemEmployeeView.Click
        Try
            Dim editor As windowEmployeeEditor = New windowEmployeeEditor("View")
            'chooser.groupBoxEmployees.Visibility = Visibility.Visible
            With editor
                Title = "Employee View"
                .userControlEmployeeChooser.IsEnabled = True
                .groupBoxDetails.Visibility = Visibility.Visible
                .groupBoxEmployees.Visibility = Visibility.Visible
                .Height = 450
                .buttonAction.Visibility = Visibility.Hidden
                .buttonActionTwo.Visibility = Visibility.Hidden
                .userControlEmployeeChooser.LoadEmployees()
                .Show()
            End With
        Catch ex As Exception
            MessageBox.Show("Problem trying to display employee!", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
        End Try
    End Sub

    Private Sub menuItemEmployeeAdd_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles menuItemEmployeeAdd.Click

        Try
            Dim editor As windowEmployeeEditor = New windowEmployeeEditor("Add")
            With editor
                Title = "Employee Add"
                .userControlEmployeeChooser.IsEnabled = False
                .groupBoxDetails.Visibility = Visibility.Visible
                .groupBoxEmployees.Visibility = Visibility.Hidden
                .Height = 475
                .buttonAction.Visibility = Visibility.Visible
                .buttonActionTwo.Visibility = Visibility.Visible
                .buttonAction.Content = "Add Employee"
                .buttonActionTwo.Content = "Cancel"
                .Show()
            End With
        Catch ex As Exception
            MessageBox.Show("Problem trying to display employee!", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
        End Try

    End Sub

    Private Sub menuItemEmployeeUpdate_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles menuItemEmployeeUpdate.Click

        Try
            Dim editor As windowEmployeeEditor = New windowEmployeeEditor("Update")
            Dim chooser As EmployeeChooser = New EmployeeChooser()
            With editor
                Title = "Employee Update"
                .userControlEmployeeChooser.IsEnabled = True
                .groupBoxDetails.Visibility = Visibility.Visible
                .groupBoxEmployees.Visibility = Visibility.Visible
                .Height = 500
                .buttonAction.Visibility = Visibility.Visible
                .buttonActionTwo.Visibility = Visibility.Visible
                .buttonAction.Content = "Update Employee"
                .buttonActionTwo.Content = "Cancel"
                .userControlEmployeeChooser.LoadEmployees()
                .Show()
            End With
        Catch ex As Exception
            MessageBox.Show("Problem trying to display employee!", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
        End Try

    End Sub

    Private Sub menuItemEmployeeDelete_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles menuItemEmployeeDelete.Click

        Try
            Dim editor As windowEmployeeEditor = New windowEmployeeEditor("Delete")
            Dim chooser As EmployeeChooser = New EmployeeChooser()
            With editor
                Title = "Employee Delete"
                .userControlEmployeeChooser.IsEnabled = True
                .groupBoxDetails.Visibility = Visibility.Hidden
                .groupBoxEmployees.Visibility = Visibility.Visible
                .Height = 175
                .buttonAction.Visibility = Visibility.Hidden
                .buttonActionTwo.Visibility = Visibility.Hidden
                .userControlEmployeeChooser.LoadEmployees()
                .Show()
            End With
        Catch ex As Exception
            MessageBox.Show("Problem trying to display employee!", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
        End Try

    End Sub
End Class

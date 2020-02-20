Imports ExerciseObjects

Public Class windowBrokenRules

    Private objEmployee As EmployeeBR

    Public Sub New()

        ' This call is required by the designer.
        InitializeComponent()
        ButtonUpdate.Isenabled = False
        objEmployee = New EmployeeBR
        Dim hndlrEmpEvent As RuleBrokenEventHandler
        hndlrEmpEvent = AddressOf objEmployee_evntEmployeeStillBroken
        AddHandler objEmployee.evntEmployeeStillBroken, hndlrEmpEvent

        ' Add any initialization after the InitializeComponent() call.

    End Sub

    Private Sub objEmployee_evntEmployeeStillBroken(ByVal bInIsBroken As Boolean)
        If blnIsBroken Then
            ButtonUpdate.IsEnabled = False
        Else
            ButtonUpdate.IsEnabled = True
        End If
    End Sub
        End If
    End Sub

    Private Sub TextBotEmail_TextChanged(ByVal sender As System.Object, ByVal e As System.Window
        objEmployee.Email = TextBoxEmail.Text
        TextBoxEmail.Foreground = objEmployee.PropertyColors("email")
    End Sub

    Private Sub TextBoxDepartment_TextChanged (ByVal sender As System.Object, ByVal e As System.Windows
        Try
            objEmployee.DepartmentID = TextBoxDepartment.Text
        Catch ex As Exception
            objEmployee.DepartmentID = 0 'will handle non-numerics and still break the rule
        End Try
        TextBoxDepartment.Foreground = objEmployee.PropertyColors("department")
    End Sub




    Private Sub Button1_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button1.Click

    End Sub
End Class

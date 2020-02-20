Imports ExerciseObjects

Public Class windowEventExample
    Public oEmp As EmployeeBusiness

    Public Sub New()
        ' This call is required by the Windows Designer.
        InitializeComponent()

        oEmp = New EmployeeBusiness
        Dim handler1 As DepartmentFoundEventHandler = AddressOf FoundEmployeeDepartment
        AddHandler oEmp.FoundDepartment, handler1

    End Sub

    Private Sub FoundEmployeeDepartment(ByVal bFoundDept As Boolean)
        If bFoundDept Then
            labelStatus.Content = "Employee is the " & oEmp.DepartmentName & " department "
        Else
            labelStatus.Content = "This employee does not belong to any known department!"
        End If
    End Sub

    Private Sub Button1_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button1.Click
        oEmp.EmployeeID = textBoxInput.Text
        oEmp.GetEmployeeDept()
        
    End Sub
End Class

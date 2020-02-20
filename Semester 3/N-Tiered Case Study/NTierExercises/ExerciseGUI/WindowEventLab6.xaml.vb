
Imports ExerciseObjects

Public Class WindowEventLab6
    Public oEmp As EmployeeBusiness

    Public Sub New()
        ' This call is required by the Windows Designer.
        InitializeComponent()

        oEmp = New EmployeeBusiness
        Dim handler1 As DepartmentFoundEventHandlerTwo = AddressOf FoundEmployeeDepartmentAndName
        AddHandler oEmp.FoundDepartmentAndName, handler1

    End Sub

    Private Sub FoundEmployeeDepartmentAndName(ByVal bFoundDept As Boolean, ByVal sFoundName As String)
        If bFoundDept Then
            labelStatus.Content = "Employee " & sFoundName & " is in the " & oEmp.DepartmentName & " department "
        Else
            labelStatus.Content = "This employee does not belong to any known department!"
        End If
    End Sub

    Private Sub Button1_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button1.Click
        oEmp.EmployeeID = textInputOne.Text
        oEmp.GetEmployeeDeptAndName()

    End Sub
End Class

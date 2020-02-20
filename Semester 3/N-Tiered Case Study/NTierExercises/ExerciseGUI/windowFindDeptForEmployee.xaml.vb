Imports ExerciseObjects

Public Class windowFindDeptForEmployee

    Private Sub Button1_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button1.Click
        Try
            Dim oEmployee As EmployeeBusiness = New EmployeeBusiness
            ' EmployeeBusiness oEmployee = new EmployeeBusiness();
            oEmployee.EmployeeID = Convert.ToInt32(textBoxInput.Text)
            oEmployee.GetEmployeeDept()

            If oEmployee.LastName = "not found" Then
                labelStatus.Content = "Employee was not found!"
            Else
                labelStatus.Content = oEmployee.LastName & " is in the " & oEmployee.DepartmentName & " department."

            End If

        Catch ex As Exception
            labelStatus.Content = "Problem: " & ex.Message


        End Try
    End Sub
End Class

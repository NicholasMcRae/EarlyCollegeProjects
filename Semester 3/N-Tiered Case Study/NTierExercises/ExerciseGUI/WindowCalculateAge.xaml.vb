Imports ExerciseObjects

Public Class WindowCalculateAge

    Private Sub Button1_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button1.Click
        Try
            Dim oEmployee As EmployeeBusiness = New EmployeeBusiness
            ' EmployeeBusiness oEmployee = new EmployeeBusiness();
            oEmployee.Age = Convert.ToInt32(textBoxInput.text)
            labelStatus.Content = "Based on the age entered, you were born in and around the year " & oEmployee.CalculateBirthYear

        Catch ex As Exception
            labelStatus.Content = "Problem calculating year " & ex.Message


        End Try
    End Sub
End Class

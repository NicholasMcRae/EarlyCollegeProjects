Imports HelpdeskBusinessUserObjects
Imports HelpdeskUserControls

Public Class windowEmployeeEditor

    Dim _action As String
    Dim objEmployee As EmployeeBusinessUser
    Dim counter As Integer
    Dim updateObject As EmployeeBusinessUser

    ''' <summary>
    ''' Constructor passed string to determine functionality
    ''' </summary>
    ''' <param name="action"></param>
    ''' <remarks></remarks>
    Public Sub New(ByVal action As String)
        InitializeComponent()

        userControlEmployeeChooser.Visibility = Visibility.Visible
        groupBoxDetails.Visibility = Visibility.Visible
        _action = action


        objEmployee = New EmployeeBusinessUser
        Dim hndlrValid As RuleBrokenEventHandler
        Dim hndlrGotEmp As EmployeeChosenEventHandler


        hndlrGotEmp = AddressOf EmployeeChooser_EmployeeChosen
        hndlrValid = AddressOf objEmployee_evntEmployeeStillBroken
        AddHandler objEmployee.evntEmployeeStillBroken, hndlrValid
        AddHandler userControlEmployeeChooser.employeeChosen, hndlrGotEmp
        


    End Sub

    Private Sub EmployeeChooser_EmployeeChosen()
        Try
            'Dim iEmpKey As Integer = objChooser._id
            Dim iEmpKey As Integer = userControlEmployeeChooser.ID
            If (_action = "Update" Or _action = "View") Then
                objEmployee.GetByID(iEmpKey)
                titleBox.Text = objEmployee.Title
                firstBox.Text = objEmployee.FirstName
                lastBox.Text = objEmployee.LastName
                phoneBox.Text = objEmployee.PhoneNo
                emailBox.Text = objEmployee.Email
                departmentBox.Text = objEmployee.DepartmentID
            ElseIf _action = "Delete" Then
                Dim empRowsDeleted As Integer = objEmployee.Delete(iEmpKey)
                userControlEmployeeChooser.LoadEmployees()
                MessageBox.Show("Employee " & iEmpKey & " Deleted", "Employee Deleted!", MessageBoxButton.OK, MessageBoxImage.Information)
            End If

            If (_action = "View") Then
                titleBox.IsEnabled = False
                firstBox.IsEnabled = False
                lastBox.IsEnabled = False
                phoneBox.IsEnabled = False
                emailBox.IsEnabled = False
                departmentBox.IsEnabled = False
            End If
        Catch ex As Exception

        End Try
    End Sub

    Private Sub objEmployee_evntEmployeeStillBroken(ByVal blnIsBroken As Boolean)
        If blnIsBroken Then
            buttonAction.IsEnabled = False
        Else
            buttonAction.IsEnabled = True
        End If
    End Sub

    
    'Dim empKey As Integer = listViewEmployees.SelectedValue.EmployeeID


    'Private Sub listViewEmployees_SelectionChanged(sender As System.Object, e As System.Windows.Controls.SelectionChangedEventArgs) Handles userControlEmployeeChooser.SelectionChanged
    'Dim objEmployeeThree As EmployeeBusinessUser = New EmployeeBusinessUser
    'Dim objEmployeeFour As EmployeeBusinessUser = New EmployeeBusinessUser
    'Dim employeeChooser As EmployeeChooser = New EmployeeChooser
    'Dim empKey As Integer = EmployeeChooser._id
    ''Dim empKey As Integer = listViewEmployees.SelectedValue.EmployeeID
    '    updateObject = New EmployeeBusinessUser
    '    updateObject.GetByID(empKey)

    '    titleBox.Text = updateObject.Title
    '    firstBox.Text = updateObject.FirstName
    '    lastBox.Text = updateObject.LastName
    '    phoneBox.Text = updateObject.PhoneNo
    '    emailBox.Text = updateObject.Email
    '    departmentBox.Text = updateObject.DepartmentID

    '    Try
    '        If (_action = "View") Then
    '            titleBox.IsEnabled = False
    '            firstBox.IsEnabled = False
    '            lastBox.IsEnabled = False
    '            phoneBox.IsEnabled = False
    '            emailBox.IsEnabled = False
    '            departmentBox.IsEnabled = False
    '        End If
    '    Catch ex As Exception
    '        MessageBox.Show("Problem with view!", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
    '    End Try
    '    Try
    '        If (_action = "Delete") Then

    'Dim answer As MessageBoxResult = MessageBox.Show("Really Delete This Employee?", "Are you sure?", MessageBoxButton.YesNo, MessageBoxImage.Question)
    '            If answer = MessageBoxResult.Yes Then
    'Dim rowsDeleted As Integer = objEmployeeFour.Delete(empKey)
    'Dim outStr As String = "Rows Deleted = " & rowsDeleted
    '                If rowsDeleted > 0 Then
    'Dim objEmployee As EmployeeBusinessUser = New EmployeeBusinessUser
    'Dim objEmployees As List(Of EmployeeBusinessUser)
    '                    objEmployees = objEmployee.GetAll()
    ''here I am creating a new window and closing the current window rather than re-loading the listview
    'Dim editor As windowEmployeeEditor = New windowEmployeeEditor("Delete")
    '                    Me.Close()
    '                    With editor
    '                        Title = "Employee Delete"
    '                        .listViewEmployees.IsEnabled = True
    '                        .groupBoxDetails.Visibility = Visibility.Hidden
    '                        .groupBoxEmployees.Visibility = Visibility.Visible
    '                        .Height = 175
    '                        .buttonAction.Visibility = Visibility.Hidden
    '                        .buttonActionTwo.Visibility = Visibility.Hidden
    '                        .LoadEmployees()
    '                        .Show()
    '                    End With

    ''listViewEmployees.ItemsSource = objEmployees
    ''listViewEmployees.ItemsSource = Nothing
    ''listViewEmployees.Items.Clear()
    ''listViewEmployees.ItemsSource = objEmployees
    '                    MessageBox.Show(outStr, "Employee deleted", MessageBoxButton.OK, MessageBoxImage.Information)
    '                End If
    '            End If
    '        End If

    '    Catch ex As Exception
    '        MessageBox.Show("Problem with delete!", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
    '    End Try
    'End Sub

    Private Sub titleBox_TextChanged(sender As System.Object, e As System.Windows.Controls.TextChangedEventArgs) Handles titleBox.TextChanged
        Try
            objEmployee.Title = titleBox.Text
        Catch ex As Exception
            objEmployee.Title = 0 'will handle non-numerics and still break the rule
        End Try
        titleBox.Foreground = objEmployee.PropertyColors("title")
    End Sub

    Private Sub firstBox_TextChanged(sender As System.Object, e As System.Windows.Controls.TextChangedEventArgs) Handles firstBox.TextChanged

        Try
            objEmployee.FirstName = firstBox.Text
        Catch ex As Exception
            objEmployee.Title = 0
        End Try
        firstBox.Foreground = objEmployee.PropertyColors("firstname")

    End Sub

    Private Sub lastBox_TextChanged(sender As System.Object, e As System.Windows.Controls.TextChangedEventArgs) Handles lastBox.TextChanged

        Try
            objEmployee.LastName = lastBox.Text
        Catch ex As Exception
            objEmployee.LastName = 0

        End Try
        lastBox.Foreground = objEmployee.PropertyColors("lastname")

    End Sub

    Private Sub phoneBox_TextChanged(sender As System.Object, e As System.Windows.Controls.TextChangedEventArgs) Handles phoneBox.TextChanged
        Try
            objEmployee.PhoneNo = phoneBox.Text
        Catch ex As Exception
            objEmployee.PhoneNo = 0

        End Try
        phoneBox.Foreground = objEmployee.PropertyColors("phoneno")
    End Sub

    Private Sub emailBox_TextChanged(sender As System.Object, e As System.Windows.Controls.TextChangedEventArgs) Handles emailBox.TextChanged

        Try
            objEmployee.Email = emailBox.Text
        Catch ex As Exception
            objEmployee.Email = 0

        End Try
        emailBox.Foreground = objEmployee.PropertyColors("email")

    End Sub

    Private Sub departmentBox_TextChanged(sender As System.Object, e As System.Windows.Controls.TextChangedEventArgs) Handles departmentBox.TextChanged

        Try
            objEmployee.DepartmentID = departmentBox.Text
        Catch ex As Exception
            objEmployee.DepartmentID = 0

        End Try
        departmentBox.Foreground = objEmployee.PropertyColors("department")

    End Sub

    Private Sub buttonAction_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles buttonAction.Click

        Try

            If (_action = "Add") Then

                Dim empBus = New EmployeeBusinessUser
                empBus.Title = titleBox.Text
                empBus.FirstName = firstBox.Text
                empBus.LastName = lastBox.Text
                empBus.PhoneNo = phoneBox.Text
                empBus.Email = emailBox.Text
                empBus.DepartmentID = departmentBox.Text

                Dim EmplID = empBus.Create()
                Dim outStr As String = "Employee Added - key = " & EmplID
                MessageBox.Show(outStr, "Test Business User Object", MessageBoxButton.OK, MessageBoxImage.Information)
            End If

            If (_action = "Update") Then

                objEmployee.Title = titleBox.Text
                objEmployee.FirstName = firstBox.Text
                objEmployee.LastName = lastBox.Text
                objEmployee.PhoneNo = phoneBox.Text
                objEmployee.Email = emailBox.Text
                objEmployee.DepartmentID = departmentBox.Text


                Dim updated = objEmployee.Update()

                Dim outStr As String = "Number of rows upaded = " & updated
                MessageBox.Show(outStr, "Test Business User Object", MessageBoxButton.OK, MessageBoxImage.Information)

            End If

        Catch ex As Exception
            If ex.Message = "Concurrency" Then
                MessageBox.Show("Employee Not Updated! - Stale Data", "You need to retrieve a fresh copy and retry", MessageBoxButton.OK, MessageBoxImage.Information)
            Else
                MessageBox.Show("Problem with action button!", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
            End If
        End Try

    End Sub

    Private Sub buttonActionTwo_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles buttonActionTwo.Click

        Try
            If (_action = "Add" Or _action = "Update") Then
                titleBox.Text = ""
                firstBox.Text = ""
                lastBox.Text = ""
                phoneBox.Text = ""
                emailBox.Text = ""
                departmentBox.Text = ""
            End If

        Catch ex As Exception
            MessageBox.Show("Not canceled!", ex.Message, MessageBoxButton.OK, MessageBoxImage.Error)
        End Try

    End Sub
End Class

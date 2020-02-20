Public Class windowSetupCaseLog

    Private Sub Button1_Click(sender As System.Object, e As System.Windows.RoutedEventArgs) Handles Button1.Click
        Try
            Dim log As New EventLog
            log.Source = TextBoxApplication.Text
            log.Log = TextBoxLog.Text
            log.WriteEntry("Test Error Message", EventLogEntryType.Error)
            MessageBox.Show("check the event viewer now", "log created!", _
                            MessageBoxButton.OK, MessageBoxImage.Information)
        Catch ex As Exception
            MessageBox.Show("log not created", ex.Message, _
                            MessageBoxButton.OK, MessageBoxImage.Error)

        End Try
    End Sub
End Class

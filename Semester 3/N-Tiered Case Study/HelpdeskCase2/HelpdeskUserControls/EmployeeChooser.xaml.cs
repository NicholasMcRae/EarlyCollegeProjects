using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using HelpdeskBusinessUserObjects;

namespace HelpdeskUserControls
{

    public delegate void EmployeeChosenEventHandler();

    /// <summary>
    /// Interaction logic for EmployeeChooser.xaml
    /// </summary>
    public partial class EmployeeChooser : UserControl
    {

        //public event EmployeeChosenEventHandler employeeChosen;
        public int _id;
        public event EmployeeChosenEventHandler employeeChosen;

        public EmployeeChooser()
        {
            InitializeComponent();
        }

        public void LoadEmployees()
        {
            try
            {
                listViewEmployees.ItemsSource = null;
                listViewEmployees.Items.Clear();
                EmployeeBusinessUser objEmployee = new EmployeeBusinessUser();
                List<EmployeeBusinessUser> objEmployees = new List<EmployeeBusinessUser>();
                objEmployees = objEmployee.GetAll();
                listViewEmployees.ItemsSource = objEmployees;
            }
            catch (Exception ex)
            {
                MessageBox.Show("You messed up yo, check the error log", "Cannot proceed with list");
            }

        }

        private void listViewEmployees_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (listViewEmployees.SelectedItems.Count > 0)
            {
                _id = Convert.ToInt32(((EmployeeBusinessUser)listViewEmployees.SelectedValue).EmployeeID);
                EmployeeChosen();
            }
        }

        private void EmployeeChosen()
        {            
            employeeChosen();
        }

        public int ID()
        {
            return _id;
        }

    }

}

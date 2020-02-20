//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Text;
//using System.Windows;
//using System.Windows.Controls;
//using System.Windows.Data;
//using System.Windows.Documents;
//using System.Windows.Input;
//using System.Windows.Media;
//using System.Windows.Media.Imaging;
//using System.Windows.Navigation;
//using System.Windows.Shapes;
//using System.Windows.Threading;

//namespace ExampleControl1
//{
//    /// <summary>
//    /// Interaction logic for Info3070Clock.xaml
//    /// </summary>
//    public partial class Info3070Clock : UserControl
//    {
//        private DispatcherTimer Timer;
//        public Info3070Clock()
//        {
//            InitializeComponent();
//        }

//        public bool ShowTime
//        {
//            set
//            {
//                Timer.IsEnabled = value;
//            }
//        }



//        //private void UserControl_Loaded(object sender, RoutedEventArgs e)
//        //{
//        //    Timer = new DispatcherTimer();
//        //    Timer.Interval = TimeSpan.FromSeconds(1);
//        //    Timer.Tick += Timer_Tick; //registers the tick event handler
//        //}

//        private void Timer_Tick(object sender, EventArgs e)
//        {
//            labelDisplay.Content = DateTime.Now.ToLongTimeString();
//        }

//        private void UserControl_Loaded(object sender, RoutedEventArgs e)
//        {
//            Timer = new DispatcherTimer();
//            Timer.Interval = TimeSpan.FromSeconds(1);
//            Timer.Tick += Timer_Tick; //registers the tick event handler
//        }

       

        

       
//    }
//}

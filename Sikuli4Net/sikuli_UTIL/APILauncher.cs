using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sikuli4Net.sikuli_UTIL
{
    public class APILauncher
    {
        private Process APIProcess;
        private ProcessStartInfo APIProcessStartInfo;
        public String API_Output;

        private String APIJar;
        private String WorkingDir;
        private String APIPath;

        public APILauncher(bool Windowless = false)
        {
            APIJar = "sikulirestapi-1.0.jar";
            WorkingDir = Directory.GetCurrentDirectory();
            APIPath = Path.Combine(WorkingDir, APIJar);
            if (Windowless == false)
            {
                APIProcessStartInfo = new ProcessStartInfo("java", "-jar \"" + APIPath + "\"");
            }
            else
            {
                APIProcessStartInfo = new ProcessStartInfo("javaw", "-jar \"" + APIPath + "\"");
            }
            APIProcess = new Process();
            APIProcess.StartInfo = APIProcessStartInfo;

            Console.WriteLine("API PATH: " + APIPath);
            Console.WriteLine("java -jar \"" + APIPath + "\"");
        }

        public void Start()
        {
            APIProcess.Start();
            //API_Output = APIProcess.StandardOutput.ReadToEndAsync().Result;
        }

        public void Stop()
        {
            APIProcess.Kill();
        }
    }
}

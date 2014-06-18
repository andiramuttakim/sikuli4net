using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;

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
		private String JarReleaseAddress;

        public APILauncher(bool Windowless = false)
        {
            APIJar = "sikulirestapi-1.0.jar";
			JarReleaseAddress = "http://sourceforge.net/projects/sikuli4net/files/sikulirestapi-1.0.jar/download";
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

            //Console.WriteLine("API PATH: " + APIPath);
            //Console.WriteLine("java -jar \"" + APIPath + "\"");
        }

        public void Start()
        {
			VerifyJarExists();
			Console.WriteLine("Starting jetty server...");
            APIProcess.Start();
        }

        public void Stop()
        {
            APIProcess.Kill();
        }
		
		public void VerifyJarExists()
		{
			if(File.Exists(APIPath))
			{
				Console.WriteLine("Jar already downloaded, launching jetty server...");
			}
			else
			{
				Console.WriteLine("Jar not downloaded, downloading jetty server jar from SourceForge...");
				WebClient client = new WebClient();
				client.DownloadFile(JarReleaseAddress,APIPath);
				Console.WriteLine("File downloaded!");
			}
		}
    }
}

/*
 * Created by SharpDevelop.
 * User: Alan
 * Date: 6/8/2014
 * Time: 9:19 PM
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;

namespace Sikuli4Net.sikuli_REST
{
	/// <summary>
	/// Description of Log.
	/// </summary>
	public class ActionLog
	{
		
		
		public ActionLog()
		{
		}
		
		/// <summary>
		/// Method to write a line to the logfile and to the console.
		/// </summary>
		/// <param name="message"></param>
		public void WriteLine(String message)
		{
			Console.WriteLine(":::" + message + ":::");
		}
	}
}

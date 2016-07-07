using System;
using System.IO;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestingAccounts
{
    public static class Utilities
    {
        // check if string is alpha
        public static bool isAlpha(string value)
        {
            foreach (char c in value)
            {
                if (!char.IsLetter(c))
                    return false;
            }
            return true;
        }
        // check if string is num
        public static bool isNumeric(string value)
        {
            foreach (char c in value)
            {
                if (!char.IsNumber(c))
                    return false;
            }
            return true;
        } 
        // checks for spaces in string
        public static bool hasSpaces(string value)
        {
            foreach (char c in value)
            {
                if (c.Equals(" "))
                    return false;
            }
        return true;
        }
        public static void Writer(Account x)
        {
            try
            {
                using (StreamWriter sr = new StreamWriter("file.txt", true))
                {
                    sr.Write(x.user.name);
                    sr.Write(" ");
                    sr.Write(x.user.lastName);
                    sr.Write(" ");
                    sr.Write(x.user.id);
                    sr.Write(" ");
                    sr.Write(x.user.accountType);
                    sr.Write(" ");
                    sr.Write(x.user.phoneNumber);
                    sr.WriteLine();

                }
            } catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }

        public static ArrayList Reader()
        {
            string line;
            ArrayList list = new ArrayList();
            using (StreamReader sr = new StreamReader("file.txt"))
            {
                while ((line = sr.ReadLine()) != null)
                {
                    string[] fLine = line.Split(' ');
                    if (fLine[3].Equals("normal")) {
                        Account newUser = new Account(fLine[0], fLine[1], int.Parse(fLine[2]), fLine[3], int.Parse(fLine[4]));
                        list.Add(newUser);
                    } else if (fLine[3].Equals("savings")) {
                        SavingsAccount newUser = new SavingsAccount(fLine[0], fLine[1], int.Parse(fLine[2]), fLine[3], int.Parse(fLine[4]));
                        list.Add(newUser);
                    } else
                    {
                        Console.WriteLine("There was an error. Account was neither a savings or normal account.");
                    }
                }
            }
            return list;
        }
    }
}

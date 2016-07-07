using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestingAccounts
{
    public class Account
    {
        private int accountNumber;
        protected decimal accountMoney;
        public User user;

        public Account(string n = "John", string l = "Doe", int i = 114252532, string at = "Normal", int p = 85456695)
        {
            Random rng = new Random();
            int ranNumber = rng.Next(0, 1000);
            this.accountNumber = ranNumber;
            this.accountMoney = 0;
            user.name = n;
            user.lastName = l;
            user.id = i;
            user.accountType = at;
            user.phoneNumber = p;

        }
        public void setAccountMoney(decimal money)
        {
            this.accountMoney = (money > 0) ? money : 0;
        }
        public decimal getAccountMoney()
        {
            return accountMoney;
        }
        public int getAccountNumber()
        {
            return this.accountNumber;
        }
        public void displayInfo()
        {
            Console.Write("Account Owner: " + this.user.name + " ");
            Console.Write(this.user.lastName + "\n");
            Console.WriteLine("Identification: " + this.user.id);
            Console.WriteLine("Account type: " + this.user.accountType);
            Console.WriteLine("Phone number: " + this.user.phoneNumber);
            Console.WriteLine("--------------");
            Console.WriteLine("Account Number: {0}", this.getAccountNumber());
            Console.WriteLine("Available Money: {0}", this.getAccountMoney());
            Console.WriteLine("--------------\n");
        }
    }

    public class SavingsAccount : Account
    {
        public SavingsAccount(string n = "John", string l = "Doe", int i = 114252532, 
            string at = "Normal", int p = 85456695) : base(n, l, i, at, p)
        {
            // nothing to do here
        }
        public decimal addMoney(decimal money)
        {
            this.accountMoney += (money + (money * (decimal) 0.05)); // bonus rate
            return this.accountMoney;
        }

        public decimal withdrawMoney (decimal money)
        {
            decimal interestRate = money * (decimal) 0.1; // interest rate
            this.accountMoney -= (money + interestRate);
            return this.accountMoney;
        }
    }
    public struct User
    {
        public string name;
        public string lastName;
        public int id;
        public string accountType;
        public int phoneNumber;
    }
}

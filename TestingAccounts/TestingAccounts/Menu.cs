using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestingAccounts
{
    class Menu
    {
        public Menu()
        {
            Console.WriteLine("Welcome to vicepresidente corp. Banking Systems. Please make a choice.\n");

            String menu = @"

    0. Exit the Program
    1. Create a new Account
    2. Deposit money to an account
    3. Withdraw money from an account
    4. View account info
    5. View all accounts [password required]";
            int? choice = 5;
            while (choice != 0)
            {
                Console.WriteLine(menu);
                choice = int.Parse(Console.ReadLine());
                switch (choice)
                {
                    case 1:
                        Account newAccount;
                        string[] userData = this.getNewAccountData();
                        if (userData[3].Equals("normal"))
                        {
                            newAccount = new Account(userData[0], userData[1],
                                int.Parse(userData[2]), userData[3], int.Parse(userData[4]));
                            Console.WriteLine("A new account has been made with account number of {0}" +
                " and has an amount of {1}. To the name of {2} {3}.", newAccount.getAccountNumber(), newAccount.getAccountMoney(), userData[0], userData[1]);
                            Utilities.Writer(newAccount);
                        }
                        else if (userData[3].Equals("savings"))
                        {
                            newAccount = new SavingsAccount(userData[0], userData[1],
                                int.Parse(userData[2]), userData[3], int.Parse(userData[4]));
                            Console.WriteLine("A new account has been made with account number of {0}" +
                " and has an amount of {1}. To the name of {2} {3}.", newAccount.getAccountNumber(), newAccount.getAccountMoney(), userData[0], userData[1]);
                            Utilities.Writer(newAccount);
                        }
                        break;
                    case 2:
                        transaction(false);
                        break;
                    case 3:
                        transaction(true);
                        break;
                    case 4:
                        Console.WriteLine("Please enter the account holder's id: ");
                        string id = Console.ReadLine();
                        Account thisAc = readList(id);
                        thisAc.displayInfo();
                        break;
                    case 5:
                        Console.WriteLine("Please enter the password: ");
                        string pass = Console.ReadLine();
                        displayList(pass);
                        break;
                    case 0:
                        Console.WriteLine("Bye.");
                        break;
                    default:
                        Console.WriteLine("That wasn't a valid choice.");
                        break;
                }
            }
        }

        // *** METHODS START HERE ***
        // gets the user data to make a new account
        public string[] getNewAccountData()
        {
            string name = "";
            string lName = "";
            string id = "";
            string accountType = "";
            string pNumber = "";
            // get first name
            while (name.Equals(""))
            {
                Console.WriteLine("What is the first name of the account holder?");
                name = Console.ReadLine();
                if (!Utilities.isAlpha(name))
                {
                    name = "";
                    Console.WriteLine("The name can't have numbers");
                }
                if (!Utilities.hasSpaces(name))
                {
                    name = "";
                    Console.WriteLine("The name can't have spaces");
                }
            }
            // get last name
            while (lName.Equals(""))
            {
                Console.WriteLine("What is the last name of the account holder?");
                lName = Console.ReadLine();
                if (!Utilities.isAlpha(lName))
                {
                    lName = "";
                    Console.WriteLine("The last name can't have numbers");
                }
                if (!Utilities.hasSpaces(lName))
                {
                    lName = "";
                    Console.WriteLine("The last name can't have spaces");
                }
            }
            // get id number
            while (id.Equals(""))
            {
                Console.WriteLine("What is the id number of the account holder?");
                id = Console.ReadLine();
                if (!Utilities.isNumeric(id))
                {
                    id = "";
                    Console.WriteLine("The id number can't have non-numeric characters");
                }
            }
            // get account type
            while (accountType.Equals(""))
            {
                Console.WriteLine("What type of account is it? Normal/Savings");
                accountType = Console.ReadLine();
                accountType = accountType.ToLower();

                if (!(accountType.Equals("normal") || accountType.Equals("savings")))
                {
                    accountType = "";
                    Console.WriteLine("The account can only be either 'Normal' or a 'Savings' account.");
                }
            }
            // get phone number
            while (pNumber.Equals(""))
            {
                Console.WriteLine("Finally, enter the account holder's phone number");
                pNumber = Console.ReadLine();
                if (!Utilities.isNumeric(pNumber))
                {
                    pNumber = "";
                    Console.WriteLine("The phone number must only have numeric characters.");
                }
            }
            string[] userData = new string[5];
            userData[0] = name;
            userData[1] = lName;
            userData[2] = id;
            userData[3] = accountType;
            userData[4] = pNumber;

            return userData;
        }

        public void displayList(string ad)
        {
            if (ad.Equals("admin"))
            {
                ArrayList list = Utilities.Reader();
                int counter = 0;
                foreach (Account ac in list)
                {
                    ++counter;
                    Console.WriteLine("Account holder No {0}", counter);
                    ac.displayInfo();
                }
            }
            else
            {
                Console.WriteLine("Wrong password. Try again or contact the administrator.");
            }
        }
        public Account readList(string id)
        {
            Account selectedAccount = null;
            ArrayList list = Utilities.Reader();
            foreach (Account ac in list)
            {
                if (ac.user.id == int.Parse(id))
                {
                    selectedAccount = ac;
                }
            }
        return selectedAccount;
        }

        public void transaction(bool b)
        {
            Console.WriteLine("Enter id of account holder: ");
            String id = Console.ReadLine();
            Account userAccount = readList(id);
            if (userAccount != null)
            {
                if (b == true)
                {
                    Console.WriteLine("How much do you want to withdraw?");
                    decimal withdraw = decimal.Parse(Console.ReadLine());
                    try
                    {
                        SavingsAccount usrAccount = (SavingsAccount)userAccount;
                        decimal mon = usrAccount.withdrawMoney(withdraw);
                        Console.WriteLine("You have {0} in your account", mon);
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine("You have a normal account. \nYou need a savings account to" +
                            " withdraw money from the bank");
                    }
                } else if (b == false)
                {
                    Console.WriteLine("How much do you want to deposit?");
                    decimal deposit = decimal.Parse(Console.ReadLine());
                    try
                    {
                        SavingsAccount usrAccount = (SavingsAccount)userAccount;
                        decimal mon = usrAccount.addMoney(deposit);
                        Console.WriteLine("You have {0} in your account", mon);
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine("You have a normal account. \nYou need a savings account to" +
                            " withdraw money from the bank");
                    }
                }
            } else if (userAccount == null) {
                Console.WriteLine("The id you entered did not match any records");
            }
        }
    }
}

>Linux Command Line Basics(Referenced from udacity).Command line flags like command names are case sensitive.  
>  **Command**  
>**curl "url from web"**  
>Download a file from the web.  
>**date**  
>prints date and time  
>**expr 2+2**  
>add 2 and 2 , print 4  
>**echo You rock**  
>print "You rock"  
>**uname**  
>prints "Linux(OS name)"  
>**hostname**  
>prints the vagrant VM's name or your machine name  
>**host udacity.com**  
>gives udacity IP address  
>**bash --version**  
>prints bash version and copyright  
>**history**  
>Prints the list of commands used previously  
>Control +R can be also used for reverse history search  
>**uptime**  
>Shows how many users are present and shell has been active for how many time.  
>**unzip**  
>unzip contents of a file  
>**cat**  
>print contents of a file  
>**wc filename**  
>For analyzing files.It tells us how many lines,words and bytes are in a file  
>**diff fileName1 fileName2**  
>it shows the difference between two files if you want to know the difference  
>**man commandname**  
>help for a given command.  
>Another useful tool for researching commands is the apropos command. You can use apropos to find commands relevant to particular keywords.  
>**ping 8.8.8.8**  
>to stop a program use control +C which will raise a stop interrupt.  

>For example apropos working directory provides a list of commands that somehow work with the current working directory. apropos is good for refreshing your memory, or for finding new commands to explore!  
>**less fileName1.txt**  
>For searching /otter (It will search for otter in fileName1.txt) Searching are case sensitive using less.  
>Scrolling up and down with arrow keys works the same way as it did before, and man you can also scroll down a page at a time by using the D key or by hitting the Space Bar.  
>You can scroll up one page at a time wit a U key. If you want to skip to very last line of the file, you can use the right angle bracket for
that.  
>To get back up to the first line use the left angle bracket.  
 You can go to a particular line by typing its line number and
hitting Enter. This is particularly useful when working  
with source code where you know the line numbers of important lines.  
>It's also useful when you decide to quickly move to the middle of a file.  
>Less also has built-in search. Type slash and then the string
you'd like to search for.Press Enter or return to execute the search.  
You can find the next occurrence of the search term by pressing n.  
To go back to the previous occurrence, use capital N.  
Search terms are case sensitive.Searching for otter with a lower case o,won't find any capital O otters.  
>If you're familiar with regular expressions you can use them here,
unless the search is actually looking for lines that match your pattern. If you don't know regular expressions,  
you can still use less search capability, but you should be
careful and only search for patterns consisting of numbers and
letters. The regular expression library will interpret other characters in ways you might not expect.  
**nano fileName.txt** : It is a command based text editor. (Use Control +X to exit nano)  



>**Difference between terminal and shell**  
When you write an input into the terminal , the shell is a program which interprets that input as a command  and runs it and provides output back to the terminal. whenever you see a .sh file, you're looking at a shell script.  
A shell script is just a text file consisting of shell commands.  
>Pretty much anything you can do from the command line, you can do in a script, too.  

>**Line based programs in shell**  
>For example if I use the following command  
>sort  
>high  
>breadth  
>(Press Control +d)  
>breadth  
>high  
**bc**  
>simple calculator which can be run.(Use quit or control +D to quit the application)  
>


----------
Linux file system   



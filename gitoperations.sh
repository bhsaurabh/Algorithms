# Navigte to my directory
cd ~prime/Dev/Algorithms

# Clean up all .class files
rm *.class

# Git based operations (This runs via a cron)
git add .
git commit -m "Commited by script on `date`"
git push -u origin master

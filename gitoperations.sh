# Navigte to my directory
cd ~prime/Dev/Algorithms

# Things that are nice to have in the cron log
echo "----------------------------------------"
date

# Clean up all .class files
rm *.class

# Git based operations (This runs via a cron)
git add .
git commit -m "Commited by script on `date`"
git push -u origin master

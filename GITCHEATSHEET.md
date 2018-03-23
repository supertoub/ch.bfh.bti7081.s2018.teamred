# Branching Model
The idea of the branching model is that there is a branch per task/subtask.

Every contributor makes changes to the branch, to merge changes into the master branch they have to create a pull request.

Every pull request needs at least one approval before it can be merged into the master branch.

# Commands
- Clone repository 
  - Over ssh: `git clone git@github.com:supertoub/ch.bfh.bti7081.s2018.teamred.git`
  - Over https: `git clone https://github.com/supertoub/ch.bfh.bti7081.s2018.teamred.git`
- list branches `git branch -l`
- create new branch `git branch newbranch`
  - set upstream (remote location) for branch `git branch -u origin newbranch`
- switch branch `git checkout newbranch`
- show status `git status`
- add file (needed for new files or changed files) `git add filename` or add all new/changed files in directory `git add .`
- commit added files `git commit -m "commit message"`
- push changes to remote `git push`

For additional information see [interactive git cheatsheet](https://ndpsoftware.com/git-cheatsheet.html).

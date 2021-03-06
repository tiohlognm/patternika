# Contributing

When contributing to this repository, please first discuss the change you wish to make via issue,
email, or any other method with the owners of this repository before making a change. 

Please note that we have a [code of conduct](CODE_OF_CONDUCT.md),
please follow it in all your interactions within the project.

## Submission Guidelines

### Bug reports

Good bug reports are extremely helpful.

Guidelines for bug reports:

1. **Use the GitHub issue search** &mdash; check if the issue has already been
   reported.
2. **Check if the issue has been fixed** &mdash; try to reproduce it using the
   latest `main` or development branch in the repository.
3. **Tell us how to reproduce you problem** &mdash; attach logs, your OS, the command with 
purpose intended and input data (if possible).

### Feature suggestions

Feature suggestions are welcome! Take a moment to make sure whether your idea
correlates with the scope and aims of the project. 

It's up to *you* to make a strong case to convince the project's developers
 of the merits of this feature. Please provide as much detail and context as possible.

### Pull requests

Good pull requests - patches, improvements, new features - are a fantastic
help. They should remain focused in scope and avoid containing unrelated
commits.

**Please ask first** before embarking on any significant pull request (e.g.
implementing features, refactoring code, porting to a different language),
otherwise you risk spending a lot of time working on something that the
project's developers might not want to merge into the project.

Please adhere to the coding and style conventions used throughout a project (indentation,
accurate comments, etc.) and any other requirements (such as test coverage).

Follow this process if you'd like your work considered for inclusion in the
project:

1. [Fork](http://help.github.com/fork-a-repo/) the project, clone your fork,
   and configure the remotes:
   ```bash
   # Clone your fork of the repo into the current directory
   git clone https://github.com/<your-username>/patternika
   # Navigate to the newly cloned directory
   cd patternika
   # Assign the original repo to a remote called "upstream"
   git remote add upstream https://github.com/patternika/patternika
   ```

2. Before starting get the latest changes from upstream:
   ```bash
   git checkout main
   git pull upstream main
   ```

3. Create a new feature branch (off the default project branch) to
   contain your feature, change, or fix:
   ```bash
   git checkout -b <your-feature-branch-name>
   ```

4. Commit your changes in logical chunks. Please adhere to these [git commit
   message guidelines](https://www.conventionalcommits.org/en/v1.0.0/#summary)
   or your code is unlikely be merged into the main project. Use Git's
   [interactive rebase](https://help.github.com/articles/interactive-rebase)
   feature to tidy up your commits before making them public.

5. Ensure any install or build dependencies are removed before the end of the layer when doing a 
   build.
   
6. Update the README.md with details of changes to the interface, this includes new options, actions
   environment variables, container parameters, etc.

7. Locally merge (or rebase) the upstream main branch into your feature branch:
   ```bash
   git pull [--rebase] upstream main
   ```   

8. Increase the version numbers in any examples files and the README.md to the new version that this
   Pull Request would represent. The versioning scheme we use is `ToDo`.

9. Make sure all checks, tests and builds are passing without any errors and warnings. 
   [Code Quality Policy](CODE_QUALITY.md)

10. Push your branch up to your fork:
   ```bash
   git push origin <your-feature-branch-name>
   ```

11. [Open a Pull Request](https://help.github.com/articles/using-pull-requests/)
    with a clear title and description.
   
12. You may merge the Pull Request in once you have the sign-off of two other developers, or if you 
    do not have permission to do that, you may request the second reviewer to merge it for you.

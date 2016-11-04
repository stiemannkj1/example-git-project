# Example Git Repository

This project is an example `git` repository for my [*Version Control*](http://stiemannkj1.gitlab.io/version-control/)
blog post.

## Get-Day Program

This program outputs the day of the week for the given date string.

## Building the project

To build the project:

1. Clone the project:

        git clone https://gitlab.com/stiemannkj1/example-git-project.git

2. Build the project with [`gradle`](https://gradle.org/):

        gradle build

The jar can be found under **`build/libs`**.

## Running the Jar

You can run the `jar` from the command line:

    java -jar build/libs/get-day.jar 2016-07-09

Output:

    SATURDAY

# License

This software is licensed under the [MIT License](https://opensource.org/licenses/MIT).


# Automated Disclosure

Automating the tedious parts of the vulnerability disclosure process.

The goal of this project is to help automate away some of the tedious parts of the vulnerability disclosure process.
In particular, enforcing a consistent disclosure policy in a way that is automated and straightforward.

## How This Repo Works

After lots of time spent dealing with disclosures on HackerOne, BugCrowd, Email, GitHub Security Advisories, Jira, ect... I've finally gotten tired of having to manually keep track of the disclosure deadlines for each respective outstanding report. In my experience, the user experience around GitHub Security Advisories is the most researcher friendly and, with a few bits of automation, the perfect platform for performing  vulnerability disclosure.

This project leverages a few bits of infrastructure to operate.
 - A GitHub account dedicated as a disclosure bot. (eg. `JLLeitschuh-disclosure-bot`)
 - A GitHub Repository for disclosures (eg. https://github.com/JLLeitschuh/security-research)

### Infrastructure

The goal of this repository is to help a security researcher that leverages GitHub Security Advisories provide regular notifications about an impending disclosure to 

Nginx
=======

## Installation

Install Nginx:

```
sudo apt-get update
sudo apt-get install nginx
```

Test the install:

`curl localhost`

This should display some HTML containing the Nginx welcome page.

Ensure the process will automatically restart on system reboot:

`sudo update-rc.d nginx defaults`

Note: This should be enabled by default.

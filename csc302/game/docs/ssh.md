SSH
=======

## Keys

### OSX

#### 1. Generate an SSH key

`ssh-keygen -t rsa`

#### 2. Add your private key to the authentication agent

`ssh-add ~/.ssh/id_rsa`

#### 3. Get your public key

`cat ~/.ssh/id_rsa.pub`

#### 4. Copy the public key to Taz, Worf, and the team server

Copy-paste the key into `~/.ssh/authorized_keys` on each of the servers.

#### 5. Ensure proper permissions

`chmod 700 ~/.ssh`

`chmod 600 ~/.ssh/authorized_keys`

#### 6. Connect via SSH

`ssh -At <taz_username>@taz.cs.wcupa.edu ssh -At worf ssh -At <username>@team5`

## Config

To simplify the connection process to Taz, the following can be added to `~/.ssh/config`:

```
Host taz
    HostName taz.cs.wcupa.edu
    User <taz_username>
```

Once this is in place, the connection string for the team server becomes

`ssh -At taz ssh -At worf ssh -At <username>@team5`

# add error
>
```
PS C:\Users\babys\Desktop\EMBEDDED> git add *
error: open("LEC/C#/INIT/.vs/INIT/FileContentIndex/582d17c8-9f74-4ddc-9679-1b64b4c02a86.vsidx"): Permission denied
error: unable to index file 'LEC/C#/INIT/.vs/INIT/FileContentIndex/582d17c8-9f74-4ddc-9679-1b64b4c02a86.vsidx'
fatal: adding files failed

PS C:\Users\babys\Desktop\EMBEDDED> git add --ignore-errors.
PS C:\Users\babys\Desktop\EMBEDDED> echo "LEC/C#/INIT/.vs/INIT/FileContentIndex/582d17c8-9f74-4ddc-9679-1b64b4c02a86.vsidx" >> .gitignore
```

# Proxy & Bridge Lab

Aida Akmurat, 250103095

Java lab with 6 tasks on the Proxy and Bridge design patterns. Plain Java, no libraries.

## How to run

```
part1/  ->  Tasks 1–3 (Proxy)
part2/  ->  Tasks 4–6 (Bridge)
```

In each folder:

```
javac Main.java
java Main
```

## Part 1 – Proxy

A proxy stands in front of the real object and controls access to it.

- **Task 1 – ProxyImage:** only `ADMIN` can view the image, others get "access denied". The image is loaded only on first view.
- **Task 2 – ProxyVideo:** counts how many times the video was played. The video is downloaded only once.
- **Task 3 – SchoolProxyInternet:** blocks `gaming.com` and `socialmedia.com`, other sites open normally.

## Part 2 – Bridge

Bridge splits "what we control" from "how it works", so both sides can grow separately.

- **Task 4 – SmartLight:** new device, works with the existing `AdvancedRemote` without changing remote code.
- **Task 5 – PartyRemote:** new remote with `partyMode()`, works with `Radio` without changing device code.
- **Task 6 – Heroes and weapons:** `Knight` / `Wizard` + `Sword` / `MagicWand`. Any hero can use any weapon, no extra classes for each combination.

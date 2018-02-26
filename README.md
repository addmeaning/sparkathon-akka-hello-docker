### Sparkathon Akka hello world container
Image for 27.02.2017 Sparkathon.

**Usage:**

to create local image:
```bash
sbt docker:publishLocal
``` 
to create an image and push it to Docker hub:

```bash
sbt docker:publish
```

to run app locally:
```bash
sbt run
```
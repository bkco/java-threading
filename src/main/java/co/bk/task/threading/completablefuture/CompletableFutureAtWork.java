package co.bk.task.threading.completablefuture;


import co.bk.task.threading.model.CreditCard;
import co.bk.task.threading.model.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CompletableFutureAtWork {

    public static void main(String[] args) {
        CompletableFutureAtWork lesson = new CompletableFutureAtWork();
        lesson.runExamples();
    }

    public CompletableFutureAtWork() {
    }

    /**
     * STUDY:
     *
     * 1.   Whats the difference between thenApply and thenAccept?
     *      Answer:
     *      1.  Look at the method signatures
     *              CompletableFuture<Void>     thenAccept(Consumer<? super T> action)
     *              <U> CompletableFuture<U>    thenApply(Function<? super T,? extends U> fn)
     *          The thenAccept takes a Consumer and returns a T=Void CF, i.e. one that does not carry
     *          a value, only the completion state.
     *          The thenApply on the other hand takes a Function and returns a CF carrying the return
     *          value of the function.
     *          the "Apply" functions apply another function and pass a future holding a value.
     *          the "Accept" functions consume this value and returns future holding void.
     *
     *
     *
     */

    // DO THIS:
    //  http://codeflex.co/java-multithreading-completablefuture-explained/
    // https://stackoverflow.com/questions/27723546/completablefuture-supplyasync-and-thenapply


    public void runExamples() {

        exampleDemonstrateApplyAndAccept();
        //exampleSequentialSteps();
//        exampleLongestLineInFile();
//
//        exampleLongestLine_inefficient();
    }

    public void exampleDemonstrateApplyAndAccept() {

        // "thenApply" returns a value. similar to map with streams.
        // "thenAccept" returns a future holding null.

        CompletableFuture.completedFuture("FUTURE")
          .thenApply(r -> r.toLowerCase())
          .thenAccept(f -> System.out.println(f))
          .thenAccept(f -> System.out.println(f))
          .thenApply(f -> new String("FUTURE"))
          .thenAccept(f -> System.out.println(f));

    }

//    public void exampleSequentialSteps() {
//        /*
//        https://stackoverflow.com/questions/27723546/completablefuture-supplyasync-and-thenapply
//         */
//
//        Actions actions = new Actions();
//        //Order order = new Order("my-new-book");
//        CreditCard creditCard = CreditCard.builder().nameOnCard("max mustermann").number("12345").build();
//
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//
//        String itemToOrder = new String("my-new-book");
//
//        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
//
//            return actions.placeOrder(itemToOrder);
//            //myservice.deleteObject(bucketName, key);
//            //return "Hello";
//            //return file;
//        }, executor)
//            .thenApply((item) -> {
//                return actions.checkAvailability(item);
//            })
//            .thenApply((item) -> {
//                  return actions.checkAvailability(item);
//            })
//            .thenAccept(deleteFile -> {
//                boolean exists = s3StorageService.doesObjectExist(bucketName, deleteFile.getFileName() + "." + deleteFile.getFileExtension());
//
//                if (exists == true)
//                    throw new CleanupException("S3 object still exists. Not completing cleanup for file");
//
//                multimediaCleanupDao.deleteCleanupMultimediaFilesFromDB(deleteFile.getId());
//            }).exceptionally(e -> {
//                log.info("deleteFileProcess: exception: " + e.getMessage());
//                System.err.println("Error! " + e.getMessage());
//                return null;
//            });
//
//
//
//    }








//    public boolean executeCleanup() throws CleanupException {
//
//        List<FileToBeDeleted> filesToDelete = multimediaCleanupDao.findCleanupMultimediaFiles(batchSize);
//
//        //ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//
//        String bucketName = "tuv-pictures-usercontent";
//
//        Consumer<FileToBeDeleted> deleteFileProcess = new Consumer<FileToBeDeleted>() {
//            public void accept(FileToBeDeleted file) {
//
//                CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
//                    String key = file.getFileName() + "." + file.getFileExtension();
//                    s3StorageService.deleteObject(bucketName, key);
//                    //return "Hello";
//                    return file;
//                }, executor)
//                        .thenApply((a) -> {
//                            try {
//                                log.info("Task execution started.");
//                                Thread.sleep(2000);
//                                log.info("Task execution stopped.");
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            return a;
//                        })
//                        .thenAccept(deleteFile -> {
//                            boolean exists = s3StorageService.doesObjectExist(bucketName, deleteFile.getFileName() + "." + deleteFile.getFileExtension());
//
//                            if (exists == true)
//                                throw new CleanupException("S3 object still exists. Not completing cleanup for file");
//
//                            multimediaCleanupDao.deleteCleanupMultimediaFilesFromDB(deleteFile.getId());
//                        }).exceptionally(e -> {
//                            log.info("deleteFileProcess: exception: " + e.getMessage());
//                            System.err.println("Error! " + e.getMessage());
//                            return null;
//                        });
//            }
//        };
//
//        filesToDelete.forEach(deleteFileProcess);
//
//        return true; // TODO review return
//    }

    // Feedback:
    // 1. streams don't handle exceptions well.
    // 2. streams are for returning collections/another stream OR .forEach() [returns nothing].
    // 3. https://www.baeldung.com/thread-pool-java-and-guava





//    filesToDelete.stream()
//            .map( file -> {
//              s3StorageService.deleteObject(bucketName, file.getFileName() + "." + file.getFileExtension());
//              return file;
//            })
//            .map((file) ->
//                    CompletableFuture.supplyAsync(() -> {
//                      boolean exists = s3StorageService.doesObjectExist(bucketName, file.getFileName() + "." + file.getFileExtension());
//                      if (exists == true) {
//                        throw new CleanupException("S3 object still exists");
////                      } else {
////                        return file;
////                      }
//                        multimediaCleanupDao.deleteCleanupMultimediaFilesFromDB(file.getId());
//                    }, executor));
//
//
//
//  }


//  (item) ->
//          CompletableFuture.supplyAsync(() -> {
//    //T result = s3StorageService.deleteObject(bucketName, item);
//    s3StorageService.deleteObject(bucketName, item);
//    //return result;
//    return item;

}

package seedu.addressbook.storage;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * An abstract class that defines the functionality of a storage
 * for the AddressBook.
 */

public abstract class Storage {


    /**
     * Signals that something went wrong when attempting to initialize a storage.
     */
    public static class InvalidStorageException extends IllegalValueException {
        public InvalidStorageException(String message){
            super(message);
        }
    }

    /**
     * Signals that some error has occurred while trying to convert and read/write data between the application
     * and the storage file.
     */
    public static class StorageOperationException extends Exception {
        public StorageOperationException(String message) {
            super(message);
        }
    }

    /**
     * Saves all the data to this storage
     * @throws StorageOperationException if there were errors converting and/or storing data to the storage
     */
    public abstract void save(AddressBook addressbook) throws StorageOperationException;

    /**
     * Loads all the data from this storage
     * @throws StorageOperationException if there were errors reading and/or converting data from program's copy
     */
    public abstract AddressBook load() throws StorageOperationException;
    public abstract String getPath();

    /**
     * @throws InvalidStorageException if the default filePath is invalid
     */
    public static Storage getStorage() throws InvalidStorageException {
        return new StorageFile();
    }

    /**
     * @throws InvalidStorageException if the given filePath is invalid
     */
    public static Storage getStorage(String filePath) throws InvalidStorageException {
        return new StorageFile(filePath);
    }
}

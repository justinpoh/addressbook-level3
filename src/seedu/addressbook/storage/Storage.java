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

    public abstract void save(AddressBook addressbook) throws StorageOperationException;
    public abstract AddressBook load() throws StorageOperationException;
    public abstract String getPath();
    public static Storage getStorage() throws InvalidStorageException {
        return new StorageFile();
    }
}

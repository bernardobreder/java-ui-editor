package editor.filesystem;

public interface IResource extends Comparable<IResource> {

	public String getName();

	public IFolder getParent();

	public default boolean isFile() {
		return this instanceof IFile;
	}

	public default boolean isFolder() {
		return this instanceof IFolder;
	}

	public default boolean isWorkspace() {
		return this instanceof IWorkspace;
	}

	public default String getExtension() {
		String name = getName();
		int index = name.lastIndexOf('.');
		if (index < 0) {
			return null;
		}
		return name.substring(index + 1);
	}

	public default IWorkspace getWorkspace() {
		IResource file = this;
		while (!file.isWorkspace()) {
			file = file.getParent();
		}
		return (IWorkspace) file;
	}

	@Override
	public default int compareTo(IResource o) {
		if (isFolder()) {
			if (!o.isFolder()) {
				return -1;
			}
		} else if (o.isFolder()) {
			if (!isFolder()) {
				return 1;
			}
		}
		return getAbsolutePath().compareTo(o.getAbsolutePath());
	}

	public default String getAbsolutePath() {
		IFolder parent = getParent();
		String name = getName();
		return parent == null ? name : parent.getAbsolutePath() + "/" + name;
	}

	public default int defaultHashCode() {
		return getAbsolutePath().hashCode();
	}

	public default boolean defaultEquals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		IResource other = (IResource) obj;
		return getAbsolutePath().equals(other.getAbsolutePath());
	}

	public default String defaultString() {
		return getAbsolutePath();
	}

}

package editor.filesystem;

import java.util.List;

public interface IFolder extends IResource {

	public List<IResource> list();

	public default IResource find(String name) {
		for (IResource file : list()) {
			if (file.getName().equals(name)) {
				return file;
			}
		}
		return null;
	}

	public default IFolder findFolder(String name) {
		for (IResource file : list()) {
			if (file.isFolder() && file.getName().equals(name)) {
				return (IFolder) file;
			}
		}
		return null;
	}

	public default IFile findFile(String name) {
		for (IResource file : list()) {
			if (file.isFile() && file.getName().equals(name)) {
				return (IFile) file;
			}
		}
		return null;
	}

}

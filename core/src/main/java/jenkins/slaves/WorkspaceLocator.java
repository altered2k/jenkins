package jenkins.slaves;

import hudson.ExtensionList;
import hudson.ExtensionPoint;
import hudson.FilePath;
import hudson.model.Node;
import hudson.model.TopLevelItem;
import jenkins.model.Jenkins;

/**
 * Allow extensions to override workspace locations
 * on given slaves or projects.
 * 
 * @author ryan.campbell@gmail.com
 * @since 1.501
 */
public abstract class WorkspaceLocator implements ExtensionPoint {
    
    /**
     * Allows extensions to customize the workspace path. The first non-null response
     * will determine the path to the workspace on that slave.
     * 
     * @param item The toplevel item
     * @param slave The slave
     * @return The absolute FilePath to the workspace on the slave. 
     * Will be created if it doesn't exist.
     * 
     */
    public abstract FilePath locate(TopLevelItem item, Node node);

    
    /**
     * All registered {@link WorkspaceLocator}s.
     */
    public static ExtensionList<WorkspaceLocator> all() {
        return Jenkins.getInstance().getExtensionList(WorkspaceLocator.class);
    }
}

 package ibator.util;
 
 import org.eclipse.core.resources.IProject;
 
 public class WEBUtil
 {
   public static void createWebXml(IProject project, String web_inf_dir) {
     org.eclipse.core.resources.IFolder folder = project.getFolder(web_inf_dir);
   }
 }



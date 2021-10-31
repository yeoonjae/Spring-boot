package me.whiteship.dempspring51;

import javax.swing.SwingContainer;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component @Scope(value = "prototype")
public class Proto {

}

package com.github.gwtbootstrap.client.ui.config;

/**
 * Column size configurator.
 * <p>
 * There is this interface for customize column size.
 * If you use custom bootstrap css and change column size, please do below settings.
 * </p>
 * <ol>
 *  <li>Create implemention of this interface or extends {@link DefaultColumnSizeConfigurator}</li>
 *  <li>Implement methods of this interface, fit your custom columns</li>
 *  <li>Add a setting to your module xml like below.</li>
 * </ol>
 * <pre>
 *  {@literal
 *  <replace-with class="com.example.config.MyColumnSizeConfigurator">
 *     <when-type-is class="com.github.gwtbootstrap.client.ui.config.ColumnSizeConfigurator"/>
 *  </replace-with>
 *  }
 *  </pre>
 * 
 * @since 2.1.1.0
 * @author ohashi keisuke
 * @see DefaultColumnSizeConfigurator
 */
public interface ColumnSizeConfigurator {

    /**
     * Get maximum span style size.
     * @return maximum span style size.
     */
    public int getMaximumSpanSize();
    
    /**
     * Get minimum span style size.
     * @return minimum span style size.
     */
    public int getMinimumSpanSize();
    
    /**
     * Get maximum offset style size.
     * @return maximum offset style size.
     */
    public int getMaximumOffsetSize();
    
    /**
     * Get minimum offset style size.
     * @return minimum offset style size.
     */
    public int getMinimumOffsetSize();
}

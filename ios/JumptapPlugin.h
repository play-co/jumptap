#import "PluginManager.h"
#import "JTAdWidget.h"

@interface JumptapPlugin : GCPlugin<JTAdWidgetDelegate>

@property (nonatomic, retain) NSString *publisherId;
@property (nonatomic, retain) JTAdWidget *widget;

- (NSString *) publisherId: (id) theWidget;

@end

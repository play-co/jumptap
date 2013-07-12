#import "JumpTapPlugin.h"
#import "JSONKit.h"


@implementation JumptapPlugin

// The plugin must call super dealloc.
- (void) dealloc {
	self.publisherId = nil;
	self.widget = nil;

	[super dealloc];
}

// The plugin must call super init.
- (id) init {
	self = [super init];
	if (!self) {
		return nil;
	}

	self.publisherId = nil;
	self.widget = nil;

	return self;
}

- (NSString *) publisherId: (id) theWidget {
	return self.publisherId;
}

- (void) initializeWithManifest:(NSDictionary *)manifest appDelegate:(TeaLeafAppDelegate *)appDelegate {
	@try {
		NSDictionary *ios = [manifest valueForKey:@"ios"];
		NSString *jumptapPublisherId = [ios valueForKey:@"jumptapPublisherId"];

		self.publisherId = jumptapPublisherId;

		self.widget = [[[JTAdWidget alloc] initWithDelegate:self shouldStartLoading:YES] autorelease];

		[JTAdWidget initializeAdService:FALSE];

		NSLog(@"{jumptap} Initialized with manifest jumptapPublisherId: '%@'", jumptapPublisherId);
	}
	@catch (NSException *exception) {
		NSLog(@"{jumptap} Failure to get jumptapPublisherId key from manifest file: %@", exception);
	}
}

@end
